package com.example.aflammy.domain.usecases.movieDetails

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.movie.WatchHistoryMapper
import com.example.aflammy.domain.models.MovieDetails
import javax.inject.Inject

class InsertMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val watchHistoryMapper: WatchHistoryMapper
) {
    suspend operator fun invoke(movie: MovieDetails) {
        return movieRepository.insertMovie(watchHistoryMapper.map(movie))
    }
}