package com.example.nightlife.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Review(

    @Json(name = "id")
    val id: Int,

    @Json(name = "barId")
    val barId: Int,

    @Json(name = "review")
    val review: String,

    @Json(name = "rating")
    val rating: Double
    )