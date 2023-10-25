package com.example.demowebflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    String URL = "https://jsonplaceholder.typicode.com/todos";
    String URL2 = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,windspeed_10m&hourly=temperature_2m,relativehumidity_2m,windspeed_10m";

    @GetMapping("/weather")
    public String getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        String weatherData = restTemplate.getForObject(URL, String.class);
        return weatherData;
    }
}
