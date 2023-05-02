package com.example.aflammy.domain.usecases.tvShowDetails

import androidx.paging.map
import com.example.aflammy.data.repository.SeriesRepository
import com.example.aflammy.domain.mappers.series.EpisodeMapper
import com.example.aflammy.domain.models.Episode
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSeasonsEpisodesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val episodeMapper: EpisodeMapper,
) {
    suspend operator fun invoke(tvShowId: Int, seasonId: Int): List<Episode> {
        return seriesRepository.getSeasonDetails(tvShowId, seasonId)?.map(episodeMapper::map) ?: emptyList()
    }
}