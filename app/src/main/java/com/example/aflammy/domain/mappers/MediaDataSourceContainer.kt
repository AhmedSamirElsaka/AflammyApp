package com.example.aflammy.domain.mappers

import com.example.aflammy.data.repository.mediaDataSource.movie.MovieByGenreDataSource
import com.example.aflammy.data.repository.mediaDataSource.movie.MovieDataSource
import com.example.aflammy.data.repository.mediaDataSource.series.TvShowDataSource
import com.example.aflammy.data.repository.mediaDataSource.series.TvShowsByGenreDataSource
import javax.inject.Inject

class MediaDataSourceContainer @Inject constructor(
    val movieByGenreDataSource: MovieByGenreDataSource,
    val tvShowsByGenreDataSource: TvShowsByGenreDataSource,
    val movieDataSource: MovieDataSource,
    val tvShowDataSource: TvShowDataSource
)