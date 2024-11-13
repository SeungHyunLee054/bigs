package com.lsh.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories(basePackages = {"com.lsh.domain.repository"})
@EntityScan(basePackages = {"com.lsh.domain.entity"})
@EnableJpaAuditing
public class ApiConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
