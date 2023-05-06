package com.example.aflammy.ui.search.uiStatMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.SearchHistory
import com.example.aflammy.ui.search.mediaSearchUIState.SearchHistoryUIState
import javax.inject.Inject


class SearchHistoryUIStateMapper @Inject constructor(): Mapper<SearchHistory, SearchHistoryUIState> {
    override fun map(input: SearchHistory): SearchHistoryUIState {
        return SearchHistoryUIState(
            input.name
        )
    }
}