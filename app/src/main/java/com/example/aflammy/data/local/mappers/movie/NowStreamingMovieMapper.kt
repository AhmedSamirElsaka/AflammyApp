package com.example.aflammy.data.local.mappers.movie

import com.example.aflammy.data.local.database.entity.movie.NowStreamingMovieEntity
import com.example.aflammy.data.local.mappers.Mapper
import com.example.aflammy.data.remote.response.MovieDto
import javax.inject.Inject

class NowStreamingMovieMapper @Inject constructor() : Mapper<MovieDto, NowStreamingMovieEntity> {
    override fun map(input: MovieDto): NowStreamingMovieEntity {
        return NowStreamingMovieEntity(
            id = input.id ?: 0,
            name = input.originalTitle ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}