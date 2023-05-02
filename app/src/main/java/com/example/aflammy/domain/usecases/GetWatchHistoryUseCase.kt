package com.example.aflammy.domain.usecases

import com.example.aflammy.data.local.database.entity.WatchHistoryEntity
import com.example.aflammy.data.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetWatchHistoryUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    operator fun invoke(): Flow<List<WatchHistoryEntity>> {
        return movieRepository.getAllWatchedMovies()
    }
}