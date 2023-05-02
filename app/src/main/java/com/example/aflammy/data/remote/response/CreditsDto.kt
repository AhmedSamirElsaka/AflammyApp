package com.example.aflammy.data.remote.response

import com.example.aflammy.data.remote.response.actor.ActorDto
import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("cast")
    val cast: List<ActorDto>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0
)