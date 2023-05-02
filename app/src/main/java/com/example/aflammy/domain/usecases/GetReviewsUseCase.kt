package com.example.aflammy.domain.usecases

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.data.repository.SeriesRepository
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.mappers.ReviewMapper
import com.example.aflammy.domain.models.Review
import javax.inject.Inject


class GetReviewsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val seriesRepository: SeriesRepository,
    private val reviewMapper: ReviewMapper,
) {

    suspend operator fun invoke(type: MediaType, mediaID: Int): List<Review> {
        val reviews = when (type) {
            MediaType.MOVIE -> movieRepository.getMovieReviews(mediaID)
            MediaType.TV_SHOW -> seriesRepository.getTvShowReviews(mediaID)
        }
        return reviews?.let {
            it.map { reviewMapper.map(it) }
        } ?: throw Throwable("Not Success")
    }

}