package com.training360.wetherapiproject.controllers;

import com.training360.wetherapiproject.dtos.WeatherDto;
import com.training360.wetherapiproject.sevices.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/weather")
public class WeatherController {

    private  final WeatherService service;

    @GetMapping("/budapest")
    public WeatherDto getCurrentWeatherDataForBudapest(){
        return service.getCurrentBudapestWeatherData();
    }
}
