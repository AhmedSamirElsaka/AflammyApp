package com.example.aflammy.ui.mappers

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Actor
import com.example.aflammy.ui.models.ActorUiState
import javax.inject.Inject

class ActorUiMapper @Inject constructor() : Mapper<Actor, ActorUiState> {
    override fun map(input: Actor): ActorUiState {

        return input.let {
            ActorUiState(
                it.actorID,
                it.actorName,
                it.actorImage
            )
        }
    }

}