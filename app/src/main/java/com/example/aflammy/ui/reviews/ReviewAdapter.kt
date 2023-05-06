package com.example.aflammy.ui.reviews

import com.example.aflammy.R
import com.example.aflammy.domain.models.Review
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener


class ReviewAdapter(items: List<Review>, listener: BaseInteractionListener
): BaseAdapter<Review>(items, listener) {
    override val layoutID: Int = R.layout.item_movie_review

}

