package com.example.aflammy.ui.myList

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.myList.myListUIState.CreatedListUIState

class CreatedListAdapter(items: List<CreatedListUIState>, listener: CreatedListInteractionListener) :
    BaseAdapter<CreatedListUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_saved_list
}

interface CreatedListInteractionListener : BaseInteractionListener {
    fun onListClick(item: CreatedListUIState)
}