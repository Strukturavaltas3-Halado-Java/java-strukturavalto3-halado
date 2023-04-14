package com.training360.wetherapiproject.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherDto {

    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    @JsonProperty("daily")
    private DailyExtremes dailyExtremes;
}
