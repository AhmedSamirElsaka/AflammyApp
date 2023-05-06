package com.example.aflammy.ui.profile.watchhistory

sealed interface WatchHistoryUIEvent {
    data class MovieEvent(val movieID: Int) : WatchHistoryUIEvent
    data class TVShowEvent(val tvShowID: Int) : WatchHistoryUIEvent
}