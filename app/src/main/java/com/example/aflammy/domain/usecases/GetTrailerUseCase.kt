package com.example.aflammy.domain.usecases

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.data.repository.SeriesRepository
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.mappers.TrailerMapper
import com.example.aflammy.domain.models.Trailer
import javax.inject.Inject


class GetTrailerUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val seriesRepository: SeriesRepository,
    private val trailerMapper: TrailerMapper
) {

    suspend operator fun invoke(mediaType: MediaType, mediaID: Int): Trailer {
        val result = when (mediaType) {
            MediaType.MOVIE -> {
                movieRepository.getMovieTrailer(mediaID)
            }
            MediaType.TV_SHOW -> {
                seriesRepository.getTvShowTrailer(mediaID)
            }
        }
        return result?.let { trailerMapper.map(it) } ?: throw Throwable("Error")
    }
}