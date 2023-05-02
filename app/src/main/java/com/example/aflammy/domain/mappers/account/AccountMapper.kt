package com.example.aflammy.domain.mappers.account

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.account.AccountDto
import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Account
import javax.inject.Inject


class AccountMapper @Inject constructor() : Mapper<AccountDto, Account> {
    override fun map(input: AccountDto): Account {
        return Account(
            avatarPath = BuildConfig.IMAGE_BASE_PATH + input.avatar?.avatarPath?.avatarPath,
            name = input.name ?: "",
            username = input.username ?: ""
        )
    }
}