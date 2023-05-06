package com.example.aflammy.ui.tvShowDetails.episodes

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener


class EpisodeAdapter(items: List<EpisodesUIState>, listener: EpisodesInteractionListener) :
    BaseAdapter<EpisodesUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_episode
}

interface EpisodesInteractionListener : BaseInteractionListener
