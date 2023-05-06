package com.example.aflammy.ui.movieDetails.mapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Actor
import com.example.aflammy.ui.models.ActorUiState
import javax.inject.Inject


class ActorUIStateMapper @Inject constructor() : Mapper<Actor, ActorUiState> {
    override fun map(input: Actor): ActorUiState {
        return ActorUiState(
            id = input.actorID,
            imageUrl = input.actorImage,
            name = input.actorName
        )
    }
}