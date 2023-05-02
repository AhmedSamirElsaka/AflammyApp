package com.example.aflammy.domain.usecases.home.getData.movie

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.movie.AdventureMovieMapper
import com.example.aflammy.domain.models.Media
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAdventureMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: AdventureMovieMapper,
) {

    suspend operator fun invoke(): Flow<List<Media>> {
        return movieRepository.getAdventureMovies().map {
            it.map(movieMapper::map)
        }
    }
}