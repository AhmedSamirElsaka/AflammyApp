package com.example.aflammy.domain.usecases.login

import com.example.aflammy.data.repository.AccountRepository
import javax.inject.Inject

class LoginWithUserNameAndPasswordUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
) {
    suspend operator fun invoke(userName: String, password: String): Boolean {
        return accountRepository.loginWithUserNameANdPassword(userName, password)
    }
}