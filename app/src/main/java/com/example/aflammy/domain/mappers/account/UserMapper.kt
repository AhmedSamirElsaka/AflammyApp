package com.example.aflammy.domain.mappers.account

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.review.AuthorDetailsDto
import com.example.aflammy.domain.models.User
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class UserMapper @Inject constructor() : Mapper<AuthorDetailsDto, User> {
    override fun map(input: AuthorDetailsDto): User {
        return User(
            BuildConfig.IMAGE_BASE_PATH + input.avatarPath,
            input.name ?: "Guest",
            input.username ?: "Guest",
            input.rating?.toFloat()?.div(2) ?: 0F
        )
    }
}