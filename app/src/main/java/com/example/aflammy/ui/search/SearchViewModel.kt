package com.example.aflammy.ui.search

import androidx.lifecycle.viewModelScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.map
import com.example.aflammy.domain.usecases.searchUseCase.*
import com.example.aflammy.ui.base.BaseViewModel
import com.example.aflammy.ui.search.adapters.ActorSearchInteractionListener
import com.example.aflammy.ui.search.adapters.MediaSearchInteractionListener
import com.example.aflammy.ui.search.adapters.SearchHistoryInteractionListener
import com.example.aflammy.ui.search.mediaSearchUIState.MediaSearchUIError
import com.example.aflammy.ui.search.mediaSearchUIState.MediaSearchUIState
import com.example.aflammy.ui.search.mediaSearchUIState.MediaTypes
import com.example.aflammy.ui.search.mediaSearchUIState.MediaUIState
import com.example.aflammy.ui.search.uiStatMapper.SearchHistoryUIStateMapper
import com.example.aflammy.ui.search.uiStatMapper.SearchMediaUIStateMapper
import com.example.aflammy.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchHistoryUIStateMapper: SearchHistoryUIStateMapper,
    private val searchMediaUIStateMapper: SearchMediaUIStateMapper,
    private val getSearchForMovieUseCase: GetSearchForMovieUseCase,
    private val getSearchForSeriesUserCase: GetSearchForSeriesUserCase,
    private val getSearchForActorUseCase: GetSearchForActorUseCase,
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase,
    private val postSaveSearchResultUseCase: PostSaveSearchResultUseCase
) : BaseViewModel(), MediaSearchInteractionListener, ActorSearchInteractionListener,
    SearchHistoryInteractionListener {

    private val _uiState = MutableStateFlow(MediaSearchUIState())
    val uiState = _uiState.asStateFlow()

    private val _searchUIEvent = MutableStateFlow<Event<SearchUIEvent?>>(Event(null))
    val searchUIEvent = _searchUIEvent.asStateFlow()

    init {
        getAllSearchHistory()
    }

    override fun getData() {
        _searchUIEvent.update { Event(SearchUIEvent.ClickRetryEvent) }
    }

    private fun getAllSearchHistory() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                getSearchHistoryUseCase().collect { list ->
                    _uiState.update {
                        it.copy(searchHistory = list.map { item ->
                            searchHistoryUIStateMapper.map(
                                item
                            )
                        }, isLoading = false, isEmpty = false)
                    }
                }
            } catch (e: Throwable) {
                _uiState.update {
                    it.copy(mediaSearchUIError = listOf(com.example.aflammy.ui.search.mediaSearchUIState.MediaSearchUIError(0, e.message.toString())))
                }
            }
        }
    }

    fun onSearchInputChange(searchTerm: CharSequence) {
        _uiState.update { it.copy(searchInput = searchTerm.toString(), isLoading = true) }
        viewModelScope.launch {
            when (_uiState.value.searchTypes) {
                MediaTypes.MOVIE -> onSearchForMovie()
                MediaTypes.TVS_SHOW -> onSearchForSeries()
                MediaTypes.ACTOR -> onSearchForActor()
            }
        }
    }


    fun onSearchForMovie() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    searchTypes = MediaTypes.MOVIE,
                    isLoading = false,
                    searchResult = getSearchForMovieUseCase(it.searchInput).map { pagingData ->
                        pagingData.map { item -> searchMediaUIStateMapper.map(item) }
                    }
                )
            }
        }
    }

    fun onSearchForSeries() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    searchTypes = MediaTypes.TVS_SHOW,
                    isLoading = false,
                    searchResult = getSearchForSeriesUserCase(it.searchInput).map { pagingData ->
                        pagingData.map { item -> searchMediaUIStateMapper.map(item) }
                    }
                )
            }
        }
    }

    fun onSearchForActor() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    searchTypes = MediaTypes.ACTOR,
                    isLoading = false,
                    searchResult = getSearchForActorUseCase(it.searchInput).map { pagingData ->
                        pagingData.map { item -> searchMediaUIStateMapper.map(item) }
                    }
                )
            }
        }
    }


    override fun onClickMediaResult(media: MediaUIState) {
        saveSearchResult(media.mediaID, media.mediaName)
        _searchUIEvent.update { Event(SearchUIEvent.ClickMediaEvent(media)) }
    }

    override fun onClickActorResult(personID: Int, name: String) {
        saveSearchResult(personID, name)
        _searchUIEvent.update { Event(SearchUIEvent.ClickActorEvent(personID)) }
    }

    private fun saveSearchResult(id: Int, name: String) {
        viewModelScope.launch { postSaveSearchResultUseCase(id, name) }
    }

    override fun onClickSearchHistory(name: String) {
        onSearchInputChange(name)
    }

    fun onClickBack() {
        _searchUIEvent.update { Event(SearchUIEvent.ClickBackEvent) }
    }

    fun setErrorUiState(combinedLoadStates: CombinedLoadStates, itemCount: Int) {
        when (combinedLoadStates.refresh) {
            is LoadState.Loading -> {
                _uiState.update {
                    it.copy(isLoading = true, mediaSearchUIError = emptyList(), isEmpty = false)
                }
            }
            is LoadState.Error -> {
                _uiState.update {
                    it.copy(isLoading = false, mediaSearchUIError = listOf(MediaSearchUIError(404, "")), isEmpty = false)
                }
            }
            is LoadState.NotLoading -> {
                if (itemCount < 1) {
                    _uiState.update {
                        it.copy(
                            isEmpty = true,
                            isLoading = false,
                            mediaSearchUIError = emptyList()
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            isEmpty = false,
                            isLoading = false,
                            mediaSearchUIError = emptyList()
                        )
                    }
                }
            }
        }
    }

}