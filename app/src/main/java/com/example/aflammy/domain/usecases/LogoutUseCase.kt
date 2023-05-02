package com.example.aflammy.domain.usecases

import com.example.aflammy.data.repository.AccountRepository
import javax.inject.Inject


class LogoutUseCase @Inject constructor(private val accountRepository: AccountRepository) {
    suspend operator fun invoke() {
        accountRepository.logout()
    }
}