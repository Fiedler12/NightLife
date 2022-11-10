package com.example.nightlife.viewmodel

import androidx.lifecycle.ViewModel

class BarViewModel(id: Int): ViewModel() {
    val id: Int = id
    var name = "loading"
    var rating = "loading"
    var description = "loading"


    suspend fun getInfo() {
        //For getting specific information about a bar.
    }
}