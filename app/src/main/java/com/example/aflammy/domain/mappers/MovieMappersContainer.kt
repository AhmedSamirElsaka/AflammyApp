package com.example.aflammy.domain.mappers

import com.example.aflammy.domain.mappers.actor.*
import com.example.aflammy.domain.mappers.movie.*
import com.example.aflammy.domain.mappers.savedList.*
import com.example.aflammy.domain.mappers.search.*
import javax.inject.Inject


class MovieMappersContainer @Inject constructor(
    val movieMapper: MovieMapper,
    val popularMovieMapper: PopularMovieMapper,
    val genreMapper: GenreMapper,
    val movieDetailsMapper: MovieDetailsMapper,
    val reviewMapper: ReviewMapper,
    val trailerMapper: TrailerMapper,
    val ratedMoviesMapper: RatedMoviesMapper,
    val actorDetailsMapper: ActorDetailsMapper,
    val actorMapper: ActorDtoMapper,
    val searchActorMapper: SearchActorMapper,
    val seriesMapper: SearchSeriesMapper,
    val searchHistoryMapper: SearchHistoryMapper,
    val itemListMapper: ItemListMapper,
    val createdListsMapper: CreatedListsMapper,
    val saveListDetailsMapper: SaveListDetailsMapper,
    val actorEntityMapper: ActorEntityMapper,
    val adventureMovieMapper: AdventureMovieMapper,
    val mysteryMovieMapper: MysteryMovieMapper,
    val nowStreamingMovieMapper: NowStreamingMovieMapper,
    val popularMovieEntityMapper: PopularMovieMapper,
    val trendingMapper: TrendingMovieMapper,
    val upcomingMovieMapper: UpcomingMovieMapper,


    )
