package com.example.nightlife.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    var loggedIn by mutableStateOf(false)



    fun logIn() {
        viewModelScope.launch {
            delay(500)
            loggedIn = !loggedIn
        }
    }
}