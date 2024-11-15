package com.lsh.domain.repository;

import com.lsh.domain.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findAllByNxAndNy(String nx, String ny);
}
