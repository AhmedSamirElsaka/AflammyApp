package com.example.aflammy.ui.movieDetails

import com.example.aflammy.ui.base.BaseInteractionListener


interface DetailInteractionListener : BaseInteractionListener {

    fun onclickBack()

    fun onClickSave()

    fun onClickPlayTrailer()

    fun onclickViewReviews()
}