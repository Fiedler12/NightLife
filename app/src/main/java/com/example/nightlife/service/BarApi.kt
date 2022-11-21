package com.example.nightlife.service

import com.example.nightlife.model.Bar
import com.example.nightlife.model.BarList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*


interface BarApi {
    @GET("/api/bar/{id}")
    suspend fun getSpecificBar(@Path("id") id: Int): Response<Bar>

    @GET("/api/bar")
    suspend fun getBars(): List<Bar>

    @GET("/api/test")
    suspend fun getTest(): Response<Object>
}