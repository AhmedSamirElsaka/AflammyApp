package com.example.aflammy.ui.movieDetails.mapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Review
import com.example.aflammy.ui.movieDetails.movieDetailsUIState.ReviewUIState
import javax.inject.Inject


class ReviewUIStateMapper @Inject constructor() : Mapper<Review, ReviewUIState> {
    override fun map(input: Review): ReviewUIState {
        return ReviewUIState(
            content = input.content,
            createDate = input.createDate,
            userImage = input.userImage,
            name = input.name,
            userName = input.userName,
            rating = input.rating
        )
    }
}