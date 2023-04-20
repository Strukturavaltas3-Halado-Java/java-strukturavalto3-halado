package training360.airplanes.mappers;

import org.mapstruct.Mapper;
import training360.airplanes.dtos.AirplaneDto;
import training360.airplanes.model.Airplane;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirplaneMapper {

    AirplaneDto toDto(Airplane airplane);

    List<AirplaneDto> toDto(List<Airplane> airplanes);
}
