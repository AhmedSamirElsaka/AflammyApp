package com.example.aflammy.domain.usecases.movieDetails

import com.example.aflammy.data.repository.MovieRepository
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.mappers.actor.ActorDtoMapper
import com.example.aflammy.domain.mappers.movie.MovieDetailsMapper
import com.example.aflammy.domain.mappers.movie.MovieMapper
import com.example.aflammy.domain.models.Actor
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.models.MediaDetailsReviews
import com.example.aflammy.domain.models.MovieDetails
import com.example.aflammy.domain.usecases.GetReviewsUseCase
import com.example.aflammy.utilities.Constants.MAX_NUM_REVIEWS
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieDetailsMapper: MovieDetailsMapper,
    private val getMovieReviewsUseCase: GetReviewsUseCase,
    private val actorMapper: ActorDtoMapper,
    private val movieMapper: MovieMapper
) {
    suspend fun getMovieDetails(movieId: Int): MovieDetails {
        val response = movieRepository.getMovieDetails(movieId)
        return response?.let {
            movieDetailsMapper.map(response)
        } ?: throw Throwable("Not Success")
    }

    suspend fun getMovieCast(movieId: Int): List<Actor> {
        return movieRepository.getMovieCast(movieId)?.cast?.let {
            it.map { actorMapper.map(it) }
        } ?: throw Throwable("Not Success")
    }

    suspend fun getMovieReviews(movieId: Int): MediaDetailsReviews {
        val reviews = getMovieReviewsUseCase(MediaType.MOVIE, movieId)
        return MediaDetailsReviews(reviews.take(MAX_NUM_REVIEWS), reviews.size > MAX_NUM_REVIEWS)
    }

    suspend fun getSimilarMovie(movieId: Int): List<Media> {
        return movieRepository.getSimilarMovie(movieId)?.let {
            it.map { movieMapper.map(it) }
        } ?: throw Throwable("Not Success")
    }
}