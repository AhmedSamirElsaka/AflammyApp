package com.example.aflammy.domain.mappers.movie

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.local.database.entity.movie.PopularMovieEntity
import com.example.aflammy.domain.models.PopularMovie
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class PopularMovieMapper @Inject constructor() : Mapper<PopularMovieEntity, PopularMovie> {
    override fun map(input: PopularMovieEntity): PopularMovie {
        return PopularMovie(
            movieID = input.id,
            title = input.title,
            imageUrl = input.imageUrl,
            movieRate = input.movieRate,
            genre = input.genre,
        )
    }
}