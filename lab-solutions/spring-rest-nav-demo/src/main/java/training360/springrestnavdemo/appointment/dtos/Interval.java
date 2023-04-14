package training360.springrestnavdemo.appointment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interval {


    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
