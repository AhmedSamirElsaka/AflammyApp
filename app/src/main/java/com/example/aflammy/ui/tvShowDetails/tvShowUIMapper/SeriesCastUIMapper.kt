package com.example.aflammy.ui.tvShowDetails.tvShowUIMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Actor
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowSeriesCastUIState
import javax.inject.Inject


class SeriesCastUIMapper @Inject constructor() : Mapper<Actor, TvShowSeriesCastUIState> {
    override fun map(input: Actor): TvShowSeriesCastUIState {
        return TvShowSeriesCastUIState(
            actorID = input.actorID,
            actorName = input.actorName,
            actorImage = input.actorImage
        )
    }
}
