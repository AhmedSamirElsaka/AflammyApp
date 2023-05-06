package com.example.aflammy.ui.profile

sealed interface ProfileUIEvent {
    object LoginEvent : ProfileUIEvent
    object RatedMoviesEvent : ProfileUIEvent
    object DialogLogoutEvent : ProfileUIEvent
    object WatchHistoryEvent : ProfileUIEvent
}
