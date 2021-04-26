package com.example.networking.entities

data class Post(
    val body: String,
    val title: String,
    val userId: Int,
    val id: Int? = -1,
)