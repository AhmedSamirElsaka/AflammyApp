package com.example.aflammy.domain.usecases.mylist

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.savedList.SaveListDetailsMapper
import com.example.aflammy.domain.models.SaveListDetails
import com.example.aflammy.utilities.ErrorUI
import javax.inject.Inject


class GetMyMediaListDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val saveListDetailsMapper: SaveListDetailsMapper
) {
    suspend operator fun invoke(listID: Int): List<SaveListDetails> {
        return movieRepository.getSavedListDetails(listID)?.map {
            saveListDetailsMapper.map(it)
        } ?: throw Throwable(ErrorUI.EMPTY_BODY)
    }
}