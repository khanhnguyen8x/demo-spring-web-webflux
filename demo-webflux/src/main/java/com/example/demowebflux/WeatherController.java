package com.example.demowebflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

    private final WebClient webClient;

    String URL = "https://jsonplaceholder.typicode.com/todos";
    String URL2 = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,windspeed_10m&hourly=temperature_2m,relativehumidity_2m,windspeed_10m";


    public WeatherController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @GetMapping("/weather")
    public Mono<String> getWeather() {
        return webClient.get()
                .uri(URL)
                .retrieve()
                .bodyToMono(String.class);
    }
}
