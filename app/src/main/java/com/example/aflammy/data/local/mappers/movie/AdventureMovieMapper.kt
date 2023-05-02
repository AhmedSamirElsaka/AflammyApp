package com.example.aflammy.data.local.mappers.movie

import com.example.aflammy.data.local.database.entity.movie.AdventureMovieEntity
import com.example.aflammy.data.local.mappers.Mapper
import com.example.aflammy.data.remote.response.MovieDto
import javax.inject.Inject

class AdventureMovieMapper @Inject constructor() : Mapper<MovieDto, AdventureMovieEntity> {
    override fun map(input: MovieDto): AdventureMovieEntity {
        return AdventureMovieEntity(
            id = input.id ?: 0,
            name = input.originalTitle ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}