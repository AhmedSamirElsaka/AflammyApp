package com.example.aflammy.data.local.mappers.movie

import com.example.aflammy.data.local.database.entity.movie.UpcomingMovieEntity
import com.example.aflammy.data.local.mappers.Mapper
import com.example.aflammy.data.remote.response.MovieDto
import javax.inject.Inject

class UpcomingMovieMapper @Inject constructor() : Mapper<MovieDto, UpcomingMovieEntity> {
    override fun map(input: MovieDto): UpcomingMovieEntity {
        return UpcomingMovieEntity(
            id = input.id ?: 0,
            name = input.originalTitle ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}