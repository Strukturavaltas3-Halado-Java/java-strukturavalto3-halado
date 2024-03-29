package training360.airplanes.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.airplanes.model.AirplaneType;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAirplaneCommand {

    private AirplaneType airplaneType;

    @NotBlank
    private String ownerAirline;
}
