package com.example.aflammy.domain.usecases

import com.example.aflammy.data.repository.AccountRepository
import com.example.aflammy.data.repository.MovieRepository
import javax.inject.Inject


class GetSessionIDUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
) {
    operator fun invoke(): String? {
        return accountRepository.getSessionId()
    }
}