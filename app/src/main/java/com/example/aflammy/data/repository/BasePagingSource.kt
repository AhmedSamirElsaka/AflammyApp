package com.example.aflammy.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState

abstract class BasePagingSource<T:Any>: PagingSource<Int, T>() {
    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition
    }

    abstract override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T>

    companion object {
        val STANDARD_PAGE_NUMBER = 1
    }
}