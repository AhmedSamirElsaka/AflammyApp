package com.example.aflammy.data.repository

import androidx.paging.Pager
import com.example.aflammy.data.local.database.entity.*
import com.example.aflammy.data.local.database.entity.series.AiringTodaySeriesEntity
import com.example.aflammy.data.local.database.entity.series.*
import com.example.aflammy.data.remote.response.*
import com.example.aflammy.data.remote.response.TvShowsDTO
import com.example.aflammy.data.remote.response.episode.EpisodeDto
import com.example.aflammy.data.remote.response.genre.GenreDto
import com.example.aflammy.data.remote.response.movie.RatingDto
import com.example.aflammy.data.remote.response.review.ReviewsDto
import com.example.aflammy.data.remote.response.trailerVideosDto.TrailerDto
import com.example.aflammy.data.remote.response.tvShow.TvShowDetailsDto
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {

    suspend fun getTVShowsGenreList(): List<GenreDto>?

    suspend fun getTvShowTrailer(tvShowId: Int): TrailerDto?

    suspend fun insertTvShow(tvShow: WatchHistoryEntity)

    suspend fun getAllTVShows(): Pager<Int, TvShowsDTO>

    suspend fun getTVShowByGenre(genreID: Int): Pager<Int, TvShowsDTO>

    suspend fun getAiringToday(): Flow<List<AiringTodaySeriesEntity>>

    suspend fun getOnTheAir(): Flow<List<OnTheAirSeriesEntity>>

    suspend fun getTopRatedTvShow(): Flow<List<TopRatedSeriesEntity>>

    fun getAiringTodayTvShowPager(): Pager<Int, TvShowsDTO>

    fun getOnTheAirTvShowPager(): Pager<Int, TvShowsDTO>

    fun getTopRatedTvShowPager(): Pager<Int, TvShowsDTO>

    fun getPopularTvShowPager(): Pager<Int, TvShowsDTO>

    suspend fun searchForSeriesPager(query: String): Pager<Int, TvShowsDTO>

    suspend fun getTvShowDetails(
        tvShowId: Int
    ): TvShowDetailsDto?

    suspend fun getTvShowCast(tvShowId: Int): CreditsDto?

    suspend fun getTvShowReviews(tvShowId: Int): List<ReviewsDto>?

    suspend fun setRating(tvShowId: Int, value: Float): RatingDto?

    suspend fun getRatedTvShow(): List<RatedTvShowDto>?

    suspend fun getSeasonDetails(tvShowId: Int, seasonId: Int): List<EpisodeDto>?

    suspend fun deleteTvShowRating(tvId: Int): RatingDto?


}