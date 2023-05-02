package com.example.aflammy.domain.usecases.tvShowDetails

import androidx.paging.map
import com.example.aflammy.data.repository.SeriesRepository
import com.example.aflammy.domain.mappers.series.EpisodeMapper
import com.example.aflammy.domain.mappers.series.WatchHistoryMapper
import com.example.aflammy.domain.models.Episode
import com.example.aflammy.domain.models.TvShowDetails
import kotlinx.coroutines.flow.map
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
