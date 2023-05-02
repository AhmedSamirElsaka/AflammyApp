package com.example.aflammy.domain.mappers.movie

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.local.database.entity.WatchHistoryEntity
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.models.MovieDetails
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject


class WatchHistoryMapper @Inject constructor() : Mapper<MovieDetails, WatchHistoryEntity> {
    override fun map(input: MovieDetails): WatchHistoryEntity {
        return WatchHistoryEntity(
            id = input.movieId,
            posterPath = BuildConfig.IMAGE_BASE_PATH + input.movieImage,
            movieTitle = input.movieName,
            voteAverage = input.movieVoteAverage,
            releaseDate = input.movieReleaseDate,
            movieDuration = input.movieDuration,
            mediaType = MediaType.MOVIE.value
        )
    }
}