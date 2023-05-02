package com.example.aflammy.domain.models

data class PopularMovie(
    val movieID: Int,
    val title: String,
    val imageUrl: String,
    val movieRate:Double,
    val genre: List<String>
)
