package com.example.aflammy.domain.mappers.actor

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.actor.ActorDto
import com.example.aflammy.domain.models.ActorDetails
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject


class ActorDetailsMapper @Inject constructor() : Mapper<ActorDto, ActorDetails> {
    override fun map(input: ActorDto): ActorDetails {

        val gender = if (input.gender == 1) {
            "Female"
        } else {
            "Male"
        }

        return ActorDetails(
            input.id ?: 0,
            input.name ?: "",
            BuildConfig.IMAGE_BASE_PATH + input.profilePath,
            input.birthday ?: "",
            input.placeOfBirth ?: "unknown",
            input.biography ?: "",
            input.knownForDepartment ?: "-",
            gender,
        )
    }
}