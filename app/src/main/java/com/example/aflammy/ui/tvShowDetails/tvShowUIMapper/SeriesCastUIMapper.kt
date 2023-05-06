package com.example.aflammy.ui.tvShowDetails.tvShowUIMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Actor
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.SeriesCastUIState
import javax.inject.Inject


class SeriesCastUIMapper @Inject constructor() : Mapper<Actor, SeriesCastUIState> {
    override fun map(input: Actor): SeriesCastUIState {
        return SeriesCastUIState(
            actorID = input.actorID,
            actorName = input.actorName,
            actorImage = input.actorImage
        )
    }
}
