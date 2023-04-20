package training360.airplanes.mappers;

import org.mapstruct.Mapper;
import training360.airplanes.dtos.RouteDto;
import training360.airplanes.model.Route;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    RouteDto toDto(Route route);
}
