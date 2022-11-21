package com.example.nightlife.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import java.text.DecimalFormat
import kotlin.random.Random


// Temporary class made to populate homescreen.
@JsonClass(generateAdapter = true)
data class BarList(val bars: List<Bar>)