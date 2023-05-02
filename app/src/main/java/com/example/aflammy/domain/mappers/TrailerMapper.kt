package com.example.aflammy.domain.mappers

import com.example.aflammy.data.remote.response.trailerVideosDto.TrailerDto
import com.example.aflammy.domain.models.Trailer
import com.example.aflammy.utilities.getKey
import javax.inject.Inject


class TrailerMapper @Inject constructor() : Mapper<TrailerDto, Trailer> {
    override fun map(input: TrailerDto): Trailer {
        return Trailer(input.results?.getKey() ?: "")
    }
}