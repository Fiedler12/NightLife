package com.example.nightlife.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Bar(

    val id: Int,

    val name: String,

    val rating: Double)