package com.example.aflammy.ui.search.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.base.BasePagingAdapter
import com.example.aflammy.ui.search.mediaSearchUIState.MediaUIState

class ActorSearchAdapter(listener: ActorSearchInteractionListener)
    : BasePagingAdapter<MediaUIState>(ActorSearchComparator, listener){
    override val layoutID: Int = R.layout.item_actor_search

    object ActorSearchComparator : DiffUtil.ItemCallback<MediaUIState>(){
        override fun areItemsTheSame(oldItem: MediaUIState, newItem: MediaUIState) =
            oldItem.mediaID == newItem.mediaID

        override fun areContentsTheSame(oldItem: MediaUIState, newItem: MediaUIState) =
            oldItem == newItem
    }
}

interface ActorSearchInteractionListener : BaseInteractionListener{
    fun onClickActorResult(personID: Int, name: String)
}