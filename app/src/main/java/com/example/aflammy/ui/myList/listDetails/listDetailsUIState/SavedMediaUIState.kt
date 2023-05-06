package com.example.aflammy.ui.myList.listDetails.listDetailsUIState

import com.example.aflammy.utilities.Constants


data class SavedMediaUIState(
    val mediaID: Int = 0,
    val title: String = "",
    val mediaType: String = Constants.MOVIE,
    val voteAverage: Double = 0.0,
    val releaseDate: String = "",
    val image: String = "",
)