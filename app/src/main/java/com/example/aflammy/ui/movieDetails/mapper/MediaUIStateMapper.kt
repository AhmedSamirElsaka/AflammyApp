package com.example.aflammy.ui.movieDetails.mapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Media
import com.example.aflammy.ui.models.MediaUiState
import javax.inject.Inject


class MediaUIStateMapper @Inject constructor() : Mapper<Media, MediaUiState> {
    override fun map(input: Media): MediaUiState {
        return MediaUiState(
            id = input.mediaID,
            imageUrl = input.mediaImage,
        )
    }
}