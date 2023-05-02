package com.example.aflammy.domain.usecases.mylist

import com.example.aflammy.data.repository.AccountRepository
import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.utilities.ErrorUI
import com.example.aflammy.utilities.checkIfExist
import javax.inject.Inject


class SaveMovieToMyListUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(listID: Int, mediaId: Int): String {
        val result = movieRepository.getListDetails(listID)

        return if (result?.checkIfExist(mediaId) == true) {
            "Fail: this movie is already on the list"
        } else {
            addMovieToList(listID, mediaId)
        }
    }

    private suspend fun addMovieToList(listID: Int, mediaId: Int): String {
        val sessionID = accountRepository.getSessionId()
        return sessionID?.let {
            movieRepository.addMovieToList(it, listID, mediaId)
            "Success: The movie has been added"
        } ?: throw Throwable(ErrorUI.NO_LOGIN)
    }
}