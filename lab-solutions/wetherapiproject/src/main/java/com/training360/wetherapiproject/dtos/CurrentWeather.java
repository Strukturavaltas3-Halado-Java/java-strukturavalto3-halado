package com.training360.wetherapiproject.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrentWeather {

    @JsonProperty("temperature")
    private double currentTemperature;
    @JsonProperty("windspeed")
    private double currentWindSpeed;

    private LocalDateTime time;
}
