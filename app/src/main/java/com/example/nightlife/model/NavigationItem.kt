package com.example.nightlife.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var title: String, var imageVector: ImageVector?) {
    object Home : NavigationItem("Home", "Home", Icons.Filled.Home)
    object Map : NavigationItem("Map", "Map", Icons.Filled.Place)
    object Search: NavigationItem("Search", "Search", Icons.Filled.Search)
    object Settings : NavigationItem("movies", "Settings", Icons.Filled.Settings)
    object Bar : NavigationItem("bar/{id}", "BarProfile", null)
}
