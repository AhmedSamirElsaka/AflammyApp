package com.example.aflammy.ui.tvShowDetails.tvShowUIState

import com.example.aflammy.ui.models.ActorUiState


data class TvShowDetailsUIState(
    val tvShowDetailsResult: TvShowDetailsResultUIState = TvShowDetailsResultUIState(),
    val seriesCastResult: List<ActorUiState> = listOf(),
    val seriesSeasonsResult: List<TvShowSeasonUIState> = listOf(),
    val seriesReviewsResult: List<TvShowReviewUIState> = listOf(),
    val detailItemResult: List<TvShowDetailItemUIState> = listOf(),
    val ratingValue: Float = 0F,
    val isLoading: Boolean = false,
    val isLogin: Boolean = false,
    val tvShowErrorUIState: List<TvShowError> = emptyList()
)
