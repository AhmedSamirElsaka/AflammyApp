package com.example.aflammy.data.local.mappers.movie

import com.example.aflammy.data.local.mappers.ActorMapper
import javax.inject.Inject

class LocalMovieMappersContainer @Inject constructor(
    val popularMovieMapper: PopularMovieMapper,
    val trendingMovieMapper: TrendingMovieMapper,
    val nowStreamingMovieMapper: NowStreamingMovieMapper,
    val upcomingMovieMapper: UpcomingMovieMapper,
    val mysteryMovieMapper: MysteryMovieMapper,
    val adventureMovieMapper: AdventureMovieMapper,
    val actorMapper: ActorMapper,
)