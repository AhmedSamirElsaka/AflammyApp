package com.example.aflammy.ui.category

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Media
import com.example.aflammy.ui.category.uiState.MediaUIState
import javax.inject.Inject

class MediaUIStateMapper @Inject constructor() : Mapper<Media, MediaUIState> {

    override fun map(input: Media): MediaUIState {
        return MediaUIState(
            mediaID = input.mediaID,
            mediaImage = input.mediaImage,
            mediaType = input.mediaType
        )
    }
}

