package com.example.aflammy.domain.mappers.search

import com.example.aflammy.data.local.database.entity.SearchHistoryEntity
import com.example.aflammy.domain.models.SearchHistory
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject


class SearchHistoryMapper @Inject constructor() : Mapper<SearchHistoryEntity, SearchHistory> {
    override fun map(input: SearchHistoryEntity): SearchHistory {
        return SearchHistory(
            id = input.id,
            name = input.search
        )
    }
}