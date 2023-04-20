package training360.airplanes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.airplanes.dtos.AirplaneDto;
import training360.airplanes.dtos.CreateAirplaneCommand;
import training360.airplanes.dtos.CreateRouteCommand;
import training360.airplanes.dtos.RouteDto;
import training360.airplanes.exceptions.AirplaneNotFoundException;
import training360.airplanes.exceptions.RouteDateNotValidException;
import training360.airplanes.exceptions.RouteNotFoundException;
import training360.airplanes.mappers.AirplaneMapper;
import training360.airplanes.mappers.RouteMapper;
import training360.airplanes.model.Airplane;
import training360.airplanes.model.Route;
import training360.airplanes.repository.AirplaneRepository;
import training360.airplanes.repository.RouteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirplaneRouteService {

    private final AirplaneRepository airplaneRepository;

    private final RouteRepository routeRepository;

    private final AirplaneMapper airplaneMapper;

    private final RouteMapper routeMapper;

    @Transactional
    public AirplaneDto saveAirplane(CreateAirplaneCommand command) {
        Airplane airplane = new Airplane(command.getAirplaneType(), command.getOwnerAirline());
        airplaneRepository.save(airplane);
        return airplaneMapper.toDto(airplane);
    }

    @Transactional
    public RouteDto saveRouteToAirplane(long id, CreateRouteCommand command) {
        Airplane airplane = airplaneRepository.findById(id).orElseThrow(() -> new AirplaneNotFoundException(id));
        if (!isFlightFreeOnDate(airplane, command.getDateOfFlight())) {
            throw new RouteDateNotValidException(command.getDateOfFlight());
        }
        Route route = new Route(command.getDepartureCity(), command.getArrivalCity(), command.getDateOfFlight());
        route.setAirplane(airplane);
        routeRepository.save(route);
        return routeMapper.toDto(route);
    }

    private boolean isFlightFreeOnDate(Airplane airplane, LocalDate date) {
        return airplane.getRoutes().stream()
                .map(Route::getDateOfFlight)
                .filter(d -> d.equals(date)).toList().isEmpty();
    }

    public List<AirplaneDto> findAllAirplanesByAirline(Optional<String> ownerAirline) {
        List<Airplane> result = airplaneRepository.findAllByOwnerAirLine(ownerAirline);
        return airplaneMapper.toDto(result);
    }

    @Transactional
    public AirplaneDto cancelFlight(long planeId, long routeId) {
        Airplane airplane = airplaneRepository.findById(planeId).orElseThrow(()->new AirplaneNotFoundException(planeId));
        Route route = routeRepository.findById(routeId).orElseThrow(()->new RouteNotFoundException(routeId));
        if(route.getAirplane()==null || route.getAirplane().getId()!=airplane.getId()){
            throw new RouteNotFoundException(routeId);
        }
        route.setAirplane(null);
        airplane.getRoutes().remove(route);
        return airplaneMapper.toDto(airplane);
    }
}
