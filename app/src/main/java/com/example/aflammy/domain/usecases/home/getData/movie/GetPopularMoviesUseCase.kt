package com.example.aflammy.domain.usecases.home.getData.movie

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.movie.PopularMovieMapper
import com.example.aflammy.domain.models.PopularMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: PopularMovieMapper,
) {
    suspend  operator fun invoke(): Flow<List<PopularMovie>> {
        return movieRepository.getPopularMovies().map { items ->
            items.map(movieMapper::map)
        }
    }
}