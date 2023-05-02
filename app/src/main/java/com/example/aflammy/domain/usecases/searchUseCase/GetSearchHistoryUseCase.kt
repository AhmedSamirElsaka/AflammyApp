package com.example.aflammy.domain.usecases.searchUseCase

import androidx.paging.map
import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.search.SearchHistoryMapper
import com.example.aflammy.domain.models.SearchHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSearchHistoryUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val searchHistoryMapper: SearchHistoryMapper
) {
    suspend operator fun invoke(): Flow<List<SearchHistory>> {
        return movieRepository.getAllSearchHistory().map { response ->
            response.map { searchHistoryMapper.map(it) }
        }
    }
}