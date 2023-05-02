package com.example.aflammy.domain.usecases.home.getData.series

import com.example.aflammy.data.repository.SeriesRepository
import com.example.aflammy.domain.mappers.series.AiringTodaySeriesMapper
import com.example.aflammy.domain.models.Media
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAiringTodaySeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val seriesMapper: AiringTodaySeriesMapper,
) {

    suspend  operator fun invoke(): Flow<List<Media>> {
        return seriesRepository.getAiringToday().map {
            it.map(seriesMapper::map)
        }
    }
}