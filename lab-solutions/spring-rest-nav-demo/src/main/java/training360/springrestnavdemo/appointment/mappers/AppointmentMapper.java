package training360.springrestnavdemo.appointment.mappers;

import org.mapstruct.Mapper;
import training360.springrestnavdemo.appointment.dtos.AppointmentDto;
import training360.springrestnavdemo.appointment.model.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentDto toDto(Appointment appointment);
}
