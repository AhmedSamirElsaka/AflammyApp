package com.example.aflammy.data.local.mappers.series

import com.example.aflammy.data.local.database.entity.series.OnTheAirSeriesEntity
import com.example.aflammy.data.local.mappers.Mapper
import com.example.aflammy.data.remote.response.TvShowsDTO
import javax.inject.Inject

class OnTheAirSeriesMapper  @Inject constructor() : Mapper<TvShowsDTO, OnTheAirSeriesEntity> {
    override fun map(input: TvShowsDTO): OnTheAirSeriesEntity {
        return OnTheAirSeriesEntity(
            id = input.id ?:0,
            name = input.originalName?:"",
            imageUrl = input.posterPath ?:""
        )
    }
}