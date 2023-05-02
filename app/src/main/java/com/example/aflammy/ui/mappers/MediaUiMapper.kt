package com.example.aflammy.ui.mappers

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Media
import com.example.aflammy.ui.models.MediaUiState
import javax.inject.Inject

class MediaUiMapper @Inject constructor() : Mapper<Media, MediaUiState> {
    override fun map(input: Media): MediaUiState {
        return input.let {
            MediaUiState(
                it.mediaID,
                it.mediaImage
            )
        }
    }

}