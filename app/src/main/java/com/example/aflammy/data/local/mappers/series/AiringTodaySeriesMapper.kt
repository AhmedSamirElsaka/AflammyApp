package com.example.aflammy.data.local.mappers.series

import com.example.aflammy.data.local.database.entity.series.AiringTodaySeriesEntity
import com.example.aflammy.data.local.mappers.Mapper
import com.example.aflammy.data.remote.response.TvShowsDTO
import javax.inject.Inject


class AiringTodaySeriesMapper @Inject constructor() : Mapper<TvShowsDTO, AiringTodaySeriesEntity> {
    override fun map(input: TvShowsDTO): AiringTodaySeriesEntity {
        return AiringTodaySeriesEntity(
            id = input.id ?: 0,
            name = input.originalName ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}