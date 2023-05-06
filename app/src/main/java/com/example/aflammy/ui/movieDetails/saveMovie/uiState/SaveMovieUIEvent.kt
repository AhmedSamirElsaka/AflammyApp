package com.example.aflammy.ui.movieDetails.saveMovie.uiState

sealed interface SaveMovieUIEvent {
    data class DisplayMessage(val message: String) : SaveMovieUIEvent
}