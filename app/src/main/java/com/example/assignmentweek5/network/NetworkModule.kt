package com.example.assignmentweek5.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun retRofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2/mentoring_kotlin_week4/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun service() : ApiService = retRofit().create(ApiService::class.java)
}