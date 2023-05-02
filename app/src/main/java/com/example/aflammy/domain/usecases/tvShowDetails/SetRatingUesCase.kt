package com.example.aflammy.domain.usecases.tvShowDetails

import androidx.paging.map
import com.example.aflammy.data.repository.SeriesRepository
import com.example.aflammy.domain.mappers.series.EpisodeMapper
import com.example.aflammy.domain.mappers.series.RatingStatusTvShowMapper
import com.example.aflammy.domain.models.Episode
import com.example.aflammy.domain.models.RatingStatus
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SetRatingUesCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val ratingStatusTvShowMapper: RatingStatusTvShowMapper
) {
    suspend operator fun invoke(tvShowId: Int, rating: Float): RatingStatus {
        val response = if (rating == 0f) {
            seriesRepository.deleteTvShowRating(tvShowId)
        } else {
            seriesRepository.setRating(tvShowId, rating)
        }
        return response?.let {
            ratingStatusTvShowMapper.map(response)
        }?: throw Throwable("Not Success")
    }
}
