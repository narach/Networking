package com.example.networking.entities.weather

data class Hourly(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val rain: Rain,
    val snow: SnowX,
    val temp: Double,
    val weather: List<WeatherX>,
    val wind_deg: Int,
    val wind_gust: Double,
    val wind_speed: Double
)