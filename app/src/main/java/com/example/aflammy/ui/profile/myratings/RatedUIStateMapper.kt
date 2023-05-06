package com.example.aflammy.ui.profile.myratings

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Rated
import javax.inject.Inject


class RatedUIStateMapper @Inject constructor() : Mapper<Rated, RatedUIState> {
    override fun map(input: Rated): RatedUIState {
        return RatedUIState(
            id = input.id,
            title = input.title,
            posterPath = input.posterPath,
            rating = input.rating,
            mediaType = input.mediaType,
            releaseDate = input.releaseDate
        )
    }
}