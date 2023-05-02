package com.example.aflammy.domain.usecases

import com.example.aflammy.data.repository.AccountRepository
import com.example.aflammy.domain.mappers.account.AccountMapper
import com.example.aflammy.domain.models.Account
import javax.inject.Inject


class GetAccountDetailsUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper
) {
    suspend operator fun invoke() : Account {
        val account = accountRepository.getAccountDetails()
        return if (account != null) {
            accountMapper.map(account)
        } else {
            throw Throwable("Account is null")
        }
    }
}