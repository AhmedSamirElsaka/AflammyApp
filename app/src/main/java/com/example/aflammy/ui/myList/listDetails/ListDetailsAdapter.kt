package com.example.aflammy.ui.myList.listDetails

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.myList.listDetails.listDetailsUIState.SavedMediaUIState

class ListDetailsAdapter(
    lists: List<SavedMediaUIState>,
    listener: ListDetailsInteractionListener
) : BaseAdapter<SavedMediaUIState>(lists,listener) {
    override val layoutID  = R.layout.item_list_details
}
interface ListDetailsInteractionListener : BaseInteractionListener {
    fun onItemClick(item: SavedMediaUIState)
}