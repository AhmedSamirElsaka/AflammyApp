package com.example.aflammy.data.local.mappers.movie

import com.example.aflammy.data.local.database.entity.movie.MysteryMovieEntity
import com.example.aflammy.data.local.mappers.Mapper
import com.example.aflammy.data.remote.response.MovieDto
import javax.inject.Inject

class MysteryMovieMapper @Inject constructor() : Mapper<MovieDto, MysteryMovieEntity> {
    override fun map(input: MovieDto): MysteryMovieEntity {
        return MysteryMovieEntity(
            id = input.id ?: 0,
            name = input.originalTitle ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}