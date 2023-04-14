package com.training360.wetherapiproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {


    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast?latitude=47.50&longitude=19.04&daily=temperature_2m_max,temperature_2m_min&current_weather=true&forecast_days=1&timezone=Europe/Berlin";

    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl(BASE_URL).build();
    }

}
