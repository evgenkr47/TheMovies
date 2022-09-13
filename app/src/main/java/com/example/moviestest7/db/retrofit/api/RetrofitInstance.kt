package com.example.moviestest7.db.retrofit.api

import com.example.moviestest7.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api: ServiceApi by lazy{
        retrofit.create(ServiceApi::class.java)
    }
}