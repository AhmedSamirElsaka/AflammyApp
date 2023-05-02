package com.example.aflammy.domain.models

import com.karrar.movieapp.domain.models.Review

data class MediaDetailsReviews(val reviews: List<Review>, val isMoreThanMax: Boolean)