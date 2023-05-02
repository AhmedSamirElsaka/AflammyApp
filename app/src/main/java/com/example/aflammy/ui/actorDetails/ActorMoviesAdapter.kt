package com.example.aflammy.ui.actorDetails

import com.example.aflammy.R
import com.example.aflammy.ui.adapters.MovieInteractionListener
import com.example.aflammy.ui.base.BaseAdapter

class ActorMoviesAdapter(items: List<ActorMoviesUIState>, val listener: MovieInteractionListener) :
    BaseAdapter<ActorMoviesUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_movie_actor
}