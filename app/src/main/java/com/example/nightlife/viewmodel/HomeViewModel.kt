package com.example.nightlife.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nightlife.model.Bar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    var loggedIn by mutableStateOf(false)
    var user: String? = null

    var bars = mutableListOf<String>("Dorsia", "1656", "Toves Vinkælder", "Kurt ravns drankerhytte")


    fun logIn() {
        loggedIn = !loggedIn
        user = "TestUser"
    }

    fun populateBars() {

    }

}