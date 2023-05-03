package com.example.aflammy.ui.allMedia.models

sealed interface MediaUIEvent {
    object BackEvent : MediaUIEvent
    object RetryEvent : MediaUIEvent
    data class ClickMovieEvent(val movieID: Int) : MediaUIEvent
    data class ClickSeriesEvent(val seriesID: Int) : MediaUIEvent
}