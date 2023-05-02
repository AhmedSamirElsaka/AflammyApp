package com.example.aflammy.domain.mappers.movie

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.RatedMoviesDto
import com.example.aflammy.domain.models.Rated
import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.utilities.Constants
import javax.inject.Inject

class RatedMoviesMapper @Inject constructor() : Mapper<RatedMoviesDto, Rated> {
    override fun map(input: RatedMoviesDto): Rated {
        return Rated(
            id = input.id ?: 0,
            title = input.title ?: "",
            posterPath = BuildConfig.IMAGE_BASE_PATH + input.backdropPath,
            rating = input.rating ?: 0F,
            releaseDate = input.releaseDate ?: "",
            mediaType = Constants.MOVIE
        )
    }
}