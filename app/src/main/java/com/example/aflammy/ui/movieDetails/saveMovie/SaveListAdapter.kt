package com.example.aflammy.ui.movieDetails.saveMovie

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.movieDetails.saveMovie.uiState.MySavedListUIState


class SaveListAdapter(
    items: List<MySavedListUIState>, listener: SaveListInteractionListener
) : BaseAdapter<MySavedListUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_list
}

interface SaveListInteractionListener : BaseInteractionListener {
    fun onClickSaveList(listID: Int)
}