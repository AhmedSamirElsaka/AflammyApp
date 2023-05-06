package com.example.aflammy.ui.tvShowDetails

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.SeasonUIState


class SeasonAdapterUIState(
    items: List<SeasonUIState>,
    listener: SeasonInteractionListener
) : BaseAdapter<SeasonUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_season
}

interface SeasonInteractionListener : BaseInteractionListener {
    fun onClickSeason(seasonNumber: Int)
}
