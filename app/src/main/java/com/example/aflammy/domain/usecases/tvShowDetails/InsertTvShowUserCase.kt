package com.example.aflammy.domain.usecases.tvShowDetails


import com.example.aflammy.data.repository.SeriesRepository
import com.example.aflammy.domain.mappers.series.WatchHistoryMapper
import com.example.aflammy.domain.models.TvShowDetails
import javax.inject.Inject


class InsertTvShowUserCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val watchHistoryMapper: WatchHistoryMapper
) {

    suspend operator fun invoke(tvShow: TvShowDetails) {
        return seriesRepository.insertTvShow(
            watchHistoryMapper.map(tvShow)
        )
    }
}
