package com.example.aflammy.domain.usecases

import com.example.aflammy.data.repository.AccountRepository
import javax.inject.Inject

class CheckIfLoggedInUseCase @Inject constructor(private val accountRepository: AccountRepository) {
    operator fun invoke() : Boolean{
        return !accountRepository.getSessionId().isNullOrBlank()
    }
}