package com.example.aflammy.ui.adapters

import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.models.ActorUiState

class ActorAdapter(items: List<ActorUiState>, val layout: Int, val listener: ActorsInteractionListener) :
    BaseAdapter<ActorUiState>(items, listener) {
    override val layoutID: Int = layout
}

interface ActorsInteractionListener : BaseInteractionListener {
    fun onClickActor(actorID: Int)
}