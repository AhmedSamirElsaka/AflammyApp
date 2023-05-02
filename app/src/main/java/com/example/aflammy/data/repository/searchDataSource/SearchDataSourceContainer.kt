package com.example.aflammy.data.repository.searchDataSource

import javax.inject.Inject

class SearchDataSourceContainer @Inject constructor(
    val movieSearchDataSource: MovieSearchDataSource,
    val seriesSearchDataSource: SeriesSearchDataSource,
    val actorSearchDataSource: ActorSearchDataSource
)
