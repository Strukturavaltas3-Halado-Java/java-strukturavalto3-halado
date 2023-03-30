package training360.springrestnavdemo.appointment.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AppointmentDto {

    private Long id;
    private String Cdv;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String typeOfAdministration;
}
