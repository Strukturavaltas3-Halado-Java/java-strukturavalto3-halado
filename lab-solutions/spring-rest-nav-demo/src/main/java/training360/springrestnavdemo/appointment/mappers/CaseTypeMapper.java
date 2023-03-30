package training360.springrestnavdemo.appointment.mappers;

import org.mapstruct.Mapper;
import training360.springrestnavdemo.appointment.dtos.CaseTypeDto;
import training360.springrestnavdemo.appointment.model.CaseType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaseTypeMapper {

    CaseTypeDto toDto(CaseType caseType);
    List<CaseTypeDto> toDto(List<CaseType> caseTypes);

}
