package com.example.aflammy.domain.models

data class Review(
    val content: String,
    val createDate: String,
    val userImage: String,
    val name: String,
    val userName: String,
    val rating: Float
)
