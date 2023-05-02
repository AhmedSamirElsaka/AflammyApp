package com.example.aflammy.ui.actorDetails

sealed interface ActorDetailsUIEvent {
    object BackEvent : ActorDetailsUIEvent
    object SeeAllMovies : ActorDetailsUIEvent
    data class ClickMovieEvent(val movieID: Int) : ActorDetailsUIEvent
}