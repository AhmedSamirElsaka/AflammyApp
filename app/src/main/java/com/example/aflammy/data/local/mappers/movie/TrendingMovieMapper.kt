package com.example.aflammy.data.local.mappers.movie

import com.example.aflammy.data.local.database.entity.movie.TrendingMovieEntity
import com.example.aflammy.data.local.mappers.Mapper
import com.example.aflammy.data.remote.response.MovieDto
import javax.inject.Inject

class TrendingMovieMapper @Inject constructor() : Mapper<MovieDto, TrendingMovieEntity> {
    override fun map(input: MovieDto): TrendingMovieEntity {
        return TrendingMovieEntity(
            id = input.id ?:0,
            name = input.originalTitle?:"",
            imageUrl = input.posterPath ?:""
        )
    }
}