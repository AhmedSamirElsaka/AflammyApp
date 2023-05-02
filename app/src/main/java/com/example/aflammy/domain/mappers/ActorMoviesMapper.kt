package com.example.aflammy.domain.mappers

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.MovieDto
import com.example.aflammy.domain.models.ActorMovie
import javax.inject.Inject


class ActorMoviesMapper @Inject constructor() : Mapper<MovieDto, ActorMovie> {
    override fun map(input: MovieDto): ActorMovie {
        return ActorMovie(
            input.id ?: 0,
            (BuildConfig.IMAGE_BASE_PATH + input.posterPath),
        )
    }
}