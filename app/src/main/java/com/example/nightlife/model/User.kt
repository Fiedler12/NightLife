package com.example.nightlife.model

class User(id: Int, name: String) {
    val id = id
    val name = name
    val favorites = mutableListOf<Int>(1, 4, 5)
}
