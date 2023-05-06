package com.example.aflammy.ui.movieDetails.saveMovie

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.CreatedList
import com.example.aflammy.ui.movieDetails.saveMovie.uiState.MyListItemUI
import javax.inject.Inject


class MyListItemUIStateMapper @Inject constructor() : Mapper<CreatedList, MyListItemUI> {
    override fun map(input: CreatedList): MyListItemUI {
        return MyListItemUI(
            listID = input.id,
            name = input.name
        )
    }
}