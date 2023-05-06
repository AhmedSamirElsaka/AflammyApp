package com.example.aflammy.ui.explore

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Media
import com.example.aflammy.ui.explore.exploreUIState.TrendyMediaUIState
import javax.inject.Inject


class TrendingUIStateMapper @Inject constructor():
    Mapper<Media, TrendyMediaUIState> {
    override fun map(input: Media): TrendyMediaUIState {
        return TrendyMediaUIState(
            input.mediaID,
            input.mediaType,
            input.mediaImage
        )
    }
}

