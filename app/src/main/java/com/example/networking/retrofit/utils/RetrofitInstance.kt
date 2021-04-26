package com.example.networking.retrofit.utils

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val postsApi: PostsApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.sampleApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PostsApi::class.java)
    }

    val weatherApi: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.openWeatherBaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}