package com.example.aflammy.ui.myList.listDetails

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.SaveListDetails
import com.example.aflammy.ui.myList.listDetails.listDetailsUIState.SavedMediaUIState
import javax.inject.Inject

class MediaUIStateMapper @Inject constructor() : Mapper<SaveListDetails, SavedMediaUIState> {

    override fun map(input: SaveListDetails): SavedMediaUIState {
        return SavedMediaUIState(
            image = input.posterPath,
            mediaID = input.id,
            title = input.title,
            voteAverage = input.voteAverage,
            releaseDate = input.releaseDate,
            mediaType = input.mediaType
        )
    }
}