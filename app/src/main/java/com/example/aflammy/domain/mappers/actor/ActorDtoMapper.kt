package com.example.aflammy.domain.mappers.actor

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.actor.ActorDto
import com.example.aflammy.domain.models.Actor
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject


class ActorDtoMapper @Inject constructor() : Mapper<ActorDto, Actor> {
    override fun map(input: ActorDto): Actor {
        return Actor(
            actorID = input.id ?: 0,
            actorName = input.name ?: "unknown",
            actorImage = BuildConfig.IMAGE_BASE_PATH + input.profilePath
        )
    }
}