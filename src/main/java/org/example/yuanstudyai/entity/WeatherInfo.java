package org.example.yuanstudyai.entity;

public record WeatherInfo(
        String city,
        String condition,
        double temperature,
        int humidity
) {
}