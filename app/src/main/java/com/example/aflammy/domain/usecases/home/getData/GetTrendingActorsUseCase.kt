package com.example.aflammy.domain.usecases.home.getData

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.actor.ActorEntityMapper
import com.example.aflammy.domain.models.Actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTrendingActorsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val actorMapper: ActorEntityMapper,
) {

    suspend operator fun invoke(): Flow<List<Actor>> {
        return movieRepository.getTrendingActors().map {
            it.map(actorMapper::map)
        }
    }
}