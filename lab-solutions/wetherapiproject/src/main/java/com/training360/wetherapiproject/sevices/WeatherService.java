package com.training360.wetherapiproject.sevices;

import com.training360.wetherapiproject.dtos.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WebClient webClient;


    public WeatherDto getCurrentBudapestWeatherData() {
        return webClient.get()
                .retrieve().bodyToMono(WeatherDto.class).block();
    }
}
