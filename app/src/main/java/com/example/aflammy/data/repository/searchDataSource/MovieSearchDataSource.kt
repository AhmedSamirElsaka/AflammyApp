package com.example.aflammy.data.repository.searchDataSource

import com.example.aflammy.data.remote.response.MovieDto
import com.example.aflammy.data.remote.service.MovieService
import com.example.aflammy.data.repository.BasePagingSource
import javax.inject.Inject
import kotlin.properties.Delegates

class MovieSearchDataSource @Inject constructor(private val service: MovieService) :
    BasePagingSource<MovieDto>() {
    private var movieSearchText by Delegates.notNull<String>()

    fun setSearchText(searchText: String) {
        movieSearchText = searchText
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        val pageNumber = params.key ?: STANDARD_PAGE_NUMBER
        return try {
            val response = service.searchForMovie(movieSearchText, pageNumber)
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