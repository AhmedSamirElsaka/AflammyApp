package com.example.aflammy.domain.usecases.mylist

import com.example.aflammy.data.repository.AccountRepository
import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.mappers.savedList.CreatedListsMapper
import com.example.aflammy.domain.models.CreatedList
import com.example.aflammy.utilities.ErrorUI
import javax.inject.Inject


class GetMyListUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
    private val movieRepository: MovieRepository,
    private val createdListsMapper: CreatedListsMapper
) {

    suspend operator fun invoke(): List<CreatedList> {
        val sessionId = accountRepository.getSessionId()
        return if (!sessionId.isNullOrBlank()) {
            val response = movieRepository.getAllLists(sessionId)
            response?.let {
                it.map { createdListsMapper.map(it) }
            }?: throw Throwable(ErrorUI.EMPTY_BODY)
        } else {
            throw Throwable(ErrorUI.NO_LOGIN)
        }
    }

}