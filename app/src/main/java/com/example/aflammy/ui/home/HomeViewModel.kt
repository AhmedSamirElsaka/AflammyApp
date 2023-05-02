package com.example.aflammy.ui.home

import com.example.aflammy.domain.usecases.home.HomeUseCasesContainer
import com.example.aflammy.ui.base.BaseViewModel
import com.example.aflammy.ui.mappers.ActorUiMapper
import com.example.aflammy.ui.mappers.MediaUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCasesContainer: HomeUseCasesContainer,
    private val mediaUiMapper: MediaUiMapper,
    private val actorUiMapper: ActorUiMapper,
    private val popularUiMapper: PopularUiMapper,
): BaseViewModel(), HomeInteractionListener, ActorsInteractionListener, MovieInteractionListener,
    MediaInteractionListener, TVShowInteractionListener{
}