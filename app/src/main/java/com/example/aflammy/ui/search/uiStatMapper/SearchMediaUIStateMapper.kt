package com.example.aflammy.ui.search.uiStatMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Media
import com.example.aflammy.ui.search.mediaSearchUIState.MediaUIState
import javax.inject.Inject


class SearchMediaUIStateMapper @Inject constructor(): Mapper<Media, MediaUIState> {
    override fun map(input: Media): MediaUIState {
        return MediaUIState(
            input.mediaID,
            input.mediaName,
            input.mediaImage,
            input.mediaType,
            input.mediaRate,
            input.mediaDate
        )
    }
}