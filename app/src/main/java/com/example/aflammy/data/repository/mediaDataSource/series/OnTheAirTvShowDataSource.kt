package com.example.aflammy.data.repository.mediaDataSource.series

import com.example.aflammy.data.remote.response.TvShowsDTO
import com.example.aflammy.data.remote.service.MovieService
import com.example.aflammy.data.repository.BasePagingSource
import javax.inject.Inject

class OnTheAirTvShowDataSource @Inject constructor(
    private val service: MovieService,
) : BasePagingSource<TvShowsDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsDTO> {
        val pageNumber = params.key ?: STANDARD_PAGE_NUMBER

        return try {
            val response = service.getOnTheAir(page = pageNumber)

            LoadResult.Page(
                data = response.body()?.items?: emptyList(),
                prevKey = null,
                nextKey = response.body()?.page?.plus(1)
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

}