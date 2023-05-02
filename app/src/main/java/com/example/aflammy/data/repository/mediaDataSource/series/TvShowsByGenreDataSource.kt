package com.example.aflammy.data.repository.mediaDataSource.series

import com.example.aflammy.data.remote.response.TvShowsDTO
import com.example.aflammy.data.remote.service.MovieService
import com.example.aflammy.data.repository.BasePagingSource
import javax.inject.Inject
import kotlin.properties.Delegates

class TvShowsByGenreDataSource @Inject constructor(private val service: MovieService) :
    BasePagingSource<TvShowsDTO>() {

    private var mediaGenreID by Delegates.notNull<Int>()

    fun setGenre(genreID: Int) {
        mediaGenreID = genreID
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsDTO> {
        val pageNumber = params.key ?: STANDARD_PAGE_NUMBER

        return try {
            val response = service.getTvListByGenre(mediaGenreID, pageNumber)

            LoadResult.Page(
                data = response.body()?.items as List<TvShowsDTO>,
                prevKey = null,
                nextKey = response.body()?.page?.plus(1)
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }
}