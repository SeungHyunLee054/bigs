package com.lsh.inquireapplication.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.lsh.weatherdomain.repository"})
@EntityScan(basePackages = {"com.lsh.weatherdomain.entity"})
@ComponentScan(basePackages = {"com.lsh.weatherapi.exception"})
@EnableJpaAuditing
public class InquireConfig {
}
