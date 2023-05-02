package com.example.aflammy.domain.usecases

import com.example.aflammy.data.repository.AccountRepository
import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.ActorMoviesMapper
import com.example.aflammy.domain.mappers.ListMapper
import com.example.aflammy.domain.models.ActorMovie
import javax.inject.Inject


class GetActorMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val actorMoviesMapper: ActorMoviesMapper,
) {

    suspend operator fun invoke(actorId: Int): List<ActorMovie> {
        val response = movieRepository.getActorMovies(actorId = actorId)
        return ListMapper(actorMoviesMapper).mapList(response?.cast)
    }
}