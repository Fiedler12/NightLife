package com.example.nightlife.service

import com.example.nightlife.model.Bar
import retrofit2.Response
import retrofit2.http.GET
import java.util.*


interface BarService {
    @GET("/api/bar/:id")
    suspend fun getSpecificBar(id: Int) {

    }

    @GET("/api/bar")
    suspend fun getBars(id: List<Int>) {


    }

    @GET("/api/test")
    suspend fun getTest(): Response<Object>
}