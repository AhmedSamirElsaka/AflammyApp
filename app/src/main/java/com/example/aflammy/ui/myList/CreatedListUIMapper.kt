package com.example.aflammy.ui.myList

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.CreatedList
import com.example.aflammy.ui.myList.myListUIState.CreatedListUIState
import javax.inject.Inject

class CreatedListUIMapper @Inject constructor() : Mapper<CreatedList, CreatedListUIState> {

    override fun map(input: CreatedList): CreatedListUIState {
        return CreatedListUIState(
            listID = input.id,
            name = input.name,
            mediaCounts = input.itemCount
        )
    }
}


