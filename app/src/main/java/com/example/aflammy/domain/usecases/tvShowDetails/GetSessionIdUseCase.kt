package com.example.aflammy.domain.usecases.tvShowDetails

import com.example.aflammy.data.repository.AccountRepository
import javax.inject.Inject

class GetSessionIdUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    operator fun invoke(): String? {
        return accountRepository.getSessionId()
    }
}
