package com.example.aflammy.ui.tvShowDetails.tvShowUIState

import androidx.lifecycle.ViewModel
import com.example.aflammy.ui.models.ActorUiState


sealed class TvShowDetailItemUIState(val priority: Int) {

    class Header(val data: TvShowDetailsResultUIState) : TvShowDetailItemUIState(0)

    class Cast(val data: List<ActorUiState>) : TvShowDetailItemUIState(1)

    class Seasons(val data: List<TvShowSeasonUIState>) : TvShowDetailItemUIState(2)

    class Rating(val viewModel: ViewModel) : TvShowDetailItemUIState(3)

    object ReviewText : TvShowDetailItemUIState(4)

    class Comment(val data: TvShowReviewUIState) : TvShowDetailItemUIState(5)

    object SeeAllReviewsButton : TvShowDetailItemUIState(6)
}
