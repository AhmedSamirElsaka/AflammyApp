package com.example.aflammy.domain.mappers.search

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.actor.ActorDto
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.utilities.Constants
import javax.inject.Inject


class SearchActorMapper @Inject constructor() : Mapper<ActorDto, Media> {
    override fun map(input: ActorDto): Media {
        return Media(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.profilePath,
            Constants.ACTOR,
            input.name ?: "",
            "",
            0F
        )
    }
}
