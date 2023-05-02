package com.example.aflammy.data.local.mappers.series

import com.example.aflammy.data.local.database.entity.series.TopRatedSeriesEntity
import com.example.aflammy.data.local.mappers.Mapper
import com.example.aflammy.data.remote.response.TvShowsDTO
import javax.inject.Inject

class TopRatedSeriesMapper @Inject constructor() : Mapper<TvShowsDTO, TopRatedSeriesEntity> {
    override fun map(input: TvShowsDTO): TopRatedSeriesEntity {
        return TopRatedSeriesEntity(
            id = input.id ?:0,
            name = input.originalName?:"",
            imageUrl = input.posterPath ?:""
        )
    }
}