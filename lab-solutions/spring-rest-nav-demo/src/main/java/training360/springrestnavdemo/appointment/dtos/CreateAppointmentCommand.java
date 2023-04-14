package training360.springrestnavdemo.appointment.dtos;

import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import training360.springrestnavdemo.appointment.validators.ValidCdv;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAppointmentCommand {


    private String Cdv;

    private Interval interval;

    private String typeOfAdministration;
}
