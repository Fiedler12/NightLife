package com.example.nightlife.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nightlife.model.Bar
import com.example.nightlife.model.Bars
import com.example.nightlife.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    var loggedIn by mutableStateOf(false)
    var user = User(1, "TestUser")
    val bars = Bars()
    var favorites = mutableListOf<Bar>()


    //
    fun logIn() {
        viewModelScope.launch {
            loggedIn = !loggedIn
            for (i in user.favorites) {
                for (b in bars.allBars) {
                    if (i == b.id) {
                        favorites.add(b)
                    }
                }
            }
        }
    }

}