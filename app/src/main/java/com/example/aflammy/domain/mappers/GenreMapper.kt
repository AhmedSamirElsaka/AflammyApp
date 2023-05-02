package com.example.aflammy.domain.mappers


import com.example.aflammy.data.remote.response.genre.GenreDto
import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Genre
import javax.inject.Inject

class GenreMapper @Inject constructor() : Mapper<GenreDto, Genre> {
    override fun map(input: GenreDto): Genre {
        return Genre(
            input.id ?: 0,
            input.name ?: "unknown"
        )
    }
}