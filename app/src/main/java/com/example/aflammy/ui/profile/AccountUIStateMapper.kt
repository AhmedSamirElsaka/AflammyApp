package com.example.aflammy.ui.profile

import com.example.aflammy.BuildConfig
import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Account
import javax.inject.Inject


class AccountUIStateMapper @Inject constructor() : Mapper<Account, ProfileUIState> {
    override fun map(input: Account): ProfileUIState {
        return ProfileUIState(
            avatarPath = BuildConfig.IMAGE_BASE_PATH + input.avatarPath,
            name = input.name,
            username = input.username
        )
    }
}