package com.example.aflammy.data.repository.searchDataSource

import com.example.aflammy.data.remote.response.TvShowsDTO
import com.example.aflammy.data.remote.service.MovieService
import com.example.aflammy.data.repository.BasePagingSource
import javax.inject.Inject
import kotlin.properties.Delegates

class SeriesSearchDataSource @Inject constructor(
    private val service: MovieService
) : BasePagingSource<TvShowsDTO>() {
    private var seriesSearchText by Delegates.notNull<String>()

    fun setSearchText(searchText: String) {
        seriesSearchText = searchText
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsDTO> {
        val pageNumber = params.key ?: STANDARD_PAGE_NUMBER
        return try {
            val response = service.searchForSeries(seriesSearchText, pageNumber)
            val pagedResponse = response.body()
            LoadResult.Page(
                data = pagedResponse?.items ?: emptyList(),
                prevKey = null,
                nextKey = if (pagedResponse?.items?.isEmpty() == true) null else pagedResponse?.page?.plus(
                    1
                )
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }
}