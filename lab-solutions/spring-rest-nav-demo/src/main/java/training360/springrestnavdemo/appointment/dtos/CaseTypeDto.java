package training360.springrestnavdemo.appointment.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CaseTypeDto {

    private String code;
    private String typeOfCase;
}
