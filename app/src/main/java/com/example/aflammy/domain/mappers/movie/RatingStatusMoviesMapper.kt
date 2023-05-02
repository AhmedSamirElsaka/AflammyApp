package com.example.aflammy.domain.mappers.movie

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.movie.RatingDto
import com.example.aflammy.domain.models.RatingStatus
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class RatingStatusMoviesMapper @Inject constructor() : Mapper<RatingDto, RatingStatus> {
    override fun map(input: RatingDto): RatingStatus {
        return RatingStatus(
            statusCode = input.statusCode ?: 0,
            statusMessage = input.statusMessage ?: "",
        )
    }
}