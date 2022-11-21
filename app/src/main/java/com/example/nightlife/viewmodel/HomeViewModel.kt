package com.example.nightlife.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nightlife.model.Bar
import com.example.nightlife.model.User
import com.example.nightlife.repositories.BarRep
import com.example.nightlife.service.BarApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel: ViewModel() {
    var loggedIn by mutableStateOf(false)
    var user = User(1, "TestUser")

    @Inject
    lateinit var barRep: BarRep

    val barState by lazy {
        barRep.getBars()
            .stateIn(this.viewModelScope, started = SharingStarted.WhileSubscribed(), emptyList<Bar>())
    }

    //
    fun logIn() {
        viewModelScope.launch {
            loggedIn = !loggedIn
        }
    }
}
