package com.example.aflammy.data.remote.response.actor

import com.example.aflammy.data.remote.response.MovieDto
import com.google.gson.annotations.SerializedName

data class ActorMoviesDto(
    @SerializedName("cast")
    val cast: List<MovieDto>? = null,
    @SerializedName("id")
    val id: Int? = null
)