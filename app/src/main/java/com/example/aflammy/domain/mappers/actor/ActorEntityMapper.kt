package com.example.aflammy.domain.mappers.actor

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.local.database.entity.ActorEntity
import com.example.aflammy.domain.models.Actor
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject


class ActorEntityMapper @Inject constructor() : Mapper<ActorEntity, Actor> {
    override fun map(input: ActorEntity): Actor {
        return Actor(
            actorID = input.id,
            actorName = input.name,
            actorImage = BuildConfig.IMAGE_BASE_PATH + input.imageUrl

        )
    }
}