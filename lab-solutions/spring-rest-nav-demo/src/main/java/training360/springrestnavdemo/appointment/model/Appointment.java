package training360.springrestnavdemo.appointment.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Appointment {

    private Long id;
    private String Cdv;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String typeOfAdministration;
}
