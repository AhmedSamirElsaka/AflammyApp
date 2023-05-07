package com.example.aflammy.ui.category

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Media
import com.example.aflammy.ui.category.uiState.CategoryMediaUIState
import javax.inject.Inject

class MediaUIStateMapper @Inject constructor() : Mapper<Media, CategoryMediaUIState> {

    override fun map(input: Media): CategoryMediaUIState {
        return CategoryMediaUIState(
            mediaID = input.mediaID,
            mediaImage = input.mediaImage,
            mediaType = input.mediaType
        )
    }
}

