package com.example.aflammy.data.repository.searchDataSource

import com.example.aflammy.data.remote.response.actor.ActorDto
import com.example.aflammy.data.remote.service.MovieService
import com.example.aflammy.data.repository.BasePagingSource
import javax.inject.Inject
import kotlin.properties.Delegates

class ActorSearchDataSource @Inject constructor(private val service: MovieService) : BasePagingSource<ActorDto>() {
    private var actorSearchText by Delegates.notNull<String>()

    fun setSearchText(searchText: String) {
        actorSearchText = searchText
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ActorDto> {
        val pageNumber = params.key ?: STANDARD_PAGE_NUMBER
        return try {
            val response = service.searchForActor(actorSearchText, pageNumber)
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