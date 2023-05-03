package com.example.aflammy.ui.home.models

data class PopularUiState(
    val movieID: Int,
    val title: String,
    val imageUrl: String,
    val movieRate:Double,
    val genre: List<String>
)