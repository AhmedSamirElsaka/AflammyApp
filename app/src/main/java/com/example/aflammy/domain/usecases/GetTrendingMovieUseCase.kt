package com.example.aflammy.domain.usecases

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.ListMapper
import com.example.aflammy.domain.mappers.MovieMappersContainer
import com.example.aflammy.domain.models.Media
import javax.inject.Inject


class GetTrendingMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMappersContainer: MovieMappersContainer,
) {
    suspend operator fun invoke(): List<Media> {
        return  ListMapper(movieMappersContainer.itemListMapper)
            .mapList(movieRepository.getDailyTrending().items)
    }
}
