package com.lsh.weatherdomain.repository;


import com.lsh.weatherdomain.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findAllByNxAndNy(String nx, String ny);
}
