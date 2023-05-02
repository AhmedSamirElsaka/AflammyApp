package com.example.aflammy.ui.adapters

import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.models.MediaUiState

class MediaAdapter(items: List<MediaUiState>, layout: Int, listener: MediaInteractionListener) :
    BaseAdapter<MediaUiState>(items, listener) {
    override val layoutID: Int = layout
}

interface MediaInteractionListener : BaseInteractionListener {
    fun onClickMedia(mediaId: Int)
}