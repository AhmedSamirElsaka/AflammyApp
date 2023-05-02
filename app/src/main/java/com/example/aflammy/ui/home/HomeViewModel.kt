package com.example.aflammy.ui.home

import androidx.lifecycle.viewModelScope
import com.example.aflammy.domain.enums.AllMediaType
import com.example.aflammy.domain.enums.HomeItemsType
import com.example.aflammy.domain.usecases.home.HomeUseCasesContainer
import com.example.aflammy.ui.adapters.ActorsInteractionListener
import com.example.aflammy.ui.adapters.MediaInteractionListener
import com.example.aflammy.ui.adapters.MovieInteractionListener
import com.example.aflammy.ui.base.BaseViewModel
import com.example.aflammy.ui.home.adapters.TVShowInteractionListener
import com.example.aflammy.ui.home.homeUiState.HomeUIEvent
import com.example.aflammy.ui.home.homeUiState.HomeUiState
import com.example.aflammy.ui.mappers.ActorUiMapper
import com.example.aflammy.ui.mappers.MediaUiMapper
import com.example.aflammy.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCasesContainer: HomeUseCasesContainer,
    private val mediaUiMapper: MediaUiMapper,
    private val actorUiMapper: ActorUiMapper,
    private val popularUiMapper: PopularUiMapper,
) : BaseViewModel(), HomeInteractionListener, ActorsInteractionListener, MovieInteractionListener,
    MediaInteractionListener, TVShowInteractionListener {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    private val _homeUiEvent = MutableStateFlow<Event<HomeUIEvent?>>(Event(null))
    val homeUIEvent = _homeUiEvent.asStateFlow()

    init {
        getHomeData()
    }

    private fun getHomeData() {
        _homeUiState.update {
            it.copy(isLoading = true)
        }
        getTrending()
        getNowStreaming()
        getUpcoming()
        getTopRatedTvShow()
        getOnTheAir()
        getAiringToday()
        getPopularMovies()
        getMystery()
        getAdventure()
        getActors()
    }

    override fun getData() {
        getHomeData()
        _homeUiState.update {
            it.copy(error = emptyList())
        }
    }

    private fun onError(message: String) {
        val errors = _homeUiState.value.error.toMutableList()
        errors.add(message)
        _homeUiState.update { it.copy(error = errors, isLoading = false) }
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getPopularMoviesUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(popularUiMapper::map)
                        _homeUiState.update {
                            it.copy(popularMovies = HomeItem.Slider(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (e: Throwable) {
                onError(e.message.toString())
            }
        }
    }

    private fun getTrending() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getTrendingMoviesUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(mediaUiMapper::map)
                        _homeUiState.update {
                            it.copy(trendingMovies = HomeItem.Trending(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }

    }

    private fun getActors() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getTrendingActorsUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(actorUiMapper::map)
                        _homeUiState.update {
                            it.copy(actors = HomeItem.Actor(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }

    }

    private fun getUpcoming() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getUpcomingMoviesUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(mediaUiMapper::map)
                        _homeUiState.update {
                            it.copy(upcomingMovies = HomeItem.Upcoming(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }


    }

    private fun getNowStreaming() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getNowStreamingMoviesUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(mediaUiMapper::map)
                        _homeUiState.update {
                            it.copy(nowStreamingMovies = HomeItem.NowStreaming(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }

    }

    private fun getTopRatedTvShow() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getTopRatedTvShowUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(mediaUiMapper::map)
                        _homeUiState.update {
                            it.copy(tvShowsSeries = HomeItem.TvShows(items),
                                isLoading = false)
                        }
                    }
                }
            }catch (t:Throwable){}
        }
    }

    private fun getOnTheAir() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getOnTheAirUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(mediaUiMapper::map)
                        _homeUiState.update {
                            it.copy(onTheAiringSeries = HomeItem.OnTheAiring(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }

    }

    private fun getAiringToday() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getAiringTodayUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(mediaUiMapper::map)
                        _homeUiState.update {
                            it.copy(airingTodaySeries = HomeItem.AiringToday(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }


    }

    private fun getMystery() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getMysteryMoviesUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(mediaUiMapper::map)
                        _homeUiState.update {
                            it.copy(mysteryMovies = HomeItem.Mystery(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }

    }

    private fun getAdventure() {
        viewModelScope.launch {
            try {
                homeUseCasesContainer.getAdventureMoviesUseCase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.map(mediaUiMapper::map)
                        _homeUiState.update {
                            it.copy(adventureMovies = HomeItem.Adventure(items),
                                isLoading = false)
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }
    }


    override fun onClickMovie(movieId: Int) {
        _homeUiEvent.update { Event(HomeUIEvent.ClickMovieEvent(movieId)) }
    }

    override fun onClickActor(actorID: Int) {
        _homeUiEvent.update { Event(HomeUIEvent.ClickActorEvent(actorID)) }
    }

    override fun onClickSeeAllMovie(homeItemsType: HomeItemsType) {
        val type = when (homeItemsType) {
            HomeItemsType.ON_THE_AIR -> AllMediaType.ON_THE_AIR
            HomeItemsType.TRENDING -> AllMediaType.TRENDING
            HomeItemsType.NOW_STREAMING -> AllMediaType.NOW_STREAMING
            HomeItemsType.UPCOMING -> AllMediaType.UPCOMING
            HomeItemsType.MYSTERY -> AllMediaType.MYSTERY
            HomeItemsType.ADVENTURE -> AllMediaType.ADVENTURE
            HomeItemsType.NON -> AllMediaType.ACTOR_MOVIES
        }
        _homeUiEvent.update { Event(HomeUIEvent.ClickSeeAllMovieEvent(type)) }
    }

    override fun onClickSeeAllActors() {
        _homeUiEvent.update { Event(HomeUIEvent.ClickSeeAllActorEvent) }

    }

    override fun onClickMedia(mediaId: Int) {
        _homeUiEvent.update { Event(HomeUIEvent.ClickSeriesEvent(mediaId)) }
    }

    override fun onClickTVShow(tVShowID: Int) {
        _homeUiEvent.update { Event(HomeUIEvent.ClickSeriesEvent(tVShowID)) }
    }

    override fun onClickSeeTVShow(type: AllMediaType) {
        _homeUiEvent.update { Event(HomeUIEvent.ClickSeeAllTVShowsEvent(type)) }
    }


}