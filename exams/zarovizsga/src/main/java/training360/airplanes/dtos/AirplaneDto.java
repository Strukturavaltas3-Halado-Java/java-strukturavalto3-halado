package training360.airplanes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.airplanes.model.AirplaneType;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneDto {

    private Long id;

    private AirplaneType airplaneType;

    private String ownerAirline;

    private Set<RouteDto> routes;
}
