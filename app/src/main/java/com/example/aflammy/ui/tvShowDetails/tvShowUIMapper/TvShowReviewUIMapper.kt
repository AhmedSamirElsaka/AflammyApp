package com.example.aflammy.ui.tvShowDetails.tvShowUIMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Review
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowReviewUIState
import javax.inject.Inject


class TvShowReviewUIMapper @Inject constructor() : Mapper<Review, TvShowReviewUIState> {
    override fun map(input: Review): TvShowReviewUIState {
        return TvShowReviewUIState(
            content = input.content,
            createDate = input.createDate,
            userImage = input.userImage,
            name = input.name,
            userName = input.userName,
            rating = input.rating
        )
    }
}
