package com.training360.wetherapiproject.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyExtremes {

    @JsonProperty("temperature_2m_max")
    private double[] maxTemperature;
    @JsonProperty("temperature_2m_min")
    private double[] minTemperature;
}
