package com.example.nightlife.model

sealed class NavigationItem(var route: String, var title: String) {
    object Home : NavigationItem("home", "Home")
    object Map : NavigationItem("music", "Music")
    object Settings : NavigationItem("movies", "Movies")
}
