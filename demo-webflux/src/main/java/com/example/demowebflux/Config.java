package com.example.demowebflux;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configurable
public class Config {

    @Bean
    public Scheduler ioScheduler() {
        return Schedulers.newBoundedElastic(10, 100, "io-pool");
    }

}
