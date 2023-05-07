package com.example.aflammy.ui.tvShowDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.aflammy.domain.models.TvShowDetails
import com.example.aflammy.domain.usecases.GetSessionIDUseCase
import com.example.aflammy.domain.usecases.tvShowDetails.GetTvShowDetailsUseCase
import com.example.aflammy.domain.usecases.tvShowDetails.InsertTvShowUserCase
import com.example.aflammy.domain.usecases.tvShowDetails.SetRatingUesCase
import com.example.aflammy.ui.adapters.ActorsInteractionListener
import com.example.aflammy.ui.base.BaseViewModel
import com.example.aflammy.ui.movieDetails.DetailInteractionListener
import com.example.aflammy.ui.movieDetails.mapper.ActorUIStateMapper
import com.example.aflammy.ui.tvShowDetails.tvShowUIMapper.TvShowMapperContainer
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowDetailItemUIState
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowDetailsUIState
import com.example.aflammy.utilities.Constants
import com.example.aflammy.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TvShowDetailsViewModel @Inject constructor(
    private val getTvShowDetailsUseCase: GetTvShowDetailsUseCase,
    private val getInsertTvShowUserCase: InsertTvShowUserCase,
    private val setRatingUesCase: SetRatingUesCase,
    private val sessionIDUseCase: GetSessionIDUseCase,
    private val tvShowMapperContainer: TvShowMapperContainer,
    private val actorUIStateMapper: ActorUIStateMapper,
    state: SavedStateHandle,
) : BaseViewModel(), ActorsInteractionListener, SeasonInteractionListener,
    DetailInteractionListener {

    val args = TvShowDetailsFragmentArgs.fromSavedStateHandle(state)

    private val _tvShowDetailsUIEvent =
        MutableStateFlow<Event<TvShowDetailsUIEvent?>>(Event(null))
    val tvShowDetailsUIEvent = this._tvShowDetailsUIEvent.asStateFlow()

    private val _stateUI = MutableStateFlow(TvShowDetailsUIState())
    val stateFlow: StateFlow<TvShowDetailsUIState> = _stateUI.asStateFlow()

    init {
        getData()
    }

    override fun getData() {
        _stateUI.update { it.copy(isLoading = true, tvShowErrorUIState = emptyList()) }
        getTvShowDetails(args.tvShowId)
        getLoginStatus()
        getTvShowCast(args.tvShowId)
        getSeasons(args.tvShowId)
        getTvShowReviews(args.tvShowId)
    }

    private fun getTvShowDetails(tvShowId: Int) {
        viewModelScope.launch {
            try {
                val result = getTvShowDetailsUseCase.getTvShowDetails(tvShowId)
                val tvShowDetailsResult = tvShowMapperContainer.tvShowDetailsUIMapper.map(result)
                _stateUI.update {
                    it.copy(
                        tvShowDetailsResult = tvShowDetailsResult,
                        isLoading = false
                    )
                }
                updateDetailItems(TvShowDetailItemUIState.Header(_stateUI.value.tvShowDetailsResult))
                insertMovieToWatchHistory(result)
            } catch (e: Exception) {
                _stateUI.update {
                    it.copy(
                        tvShowErrorUIState = listOf(
                            com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowError(
                                code = Constants.INTERNET_STATUS,
                                message = e.message.toString()
                            )
                        ),
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun getTvShowCast(tvShowId: Int) {
        viewModelScope.launch {
            try {
                val result = getTvShowDetailsUseCase.getSeriesCast(tvShowId)
                _stateUI.update { it ->
                    it.copy(
                        seriesCastResult = result.map { actorUIStateMapper.map(it) },
                        isLoading = false
                    )
                }
                updateDetailItems(TvShowDetailItemUIState.Cast(_stateUI.value.seriesCastResult))
            } catch (e: Exception) {
            }

        }
    }

    private fun getSeasons(tvShowId: Int) {
        viewModelScope.launch {
            try {
                val seasons = getTvShowDetailsUseCase.getSeasons(tvShowId)
                _stateUI.update { it ->
                    it.copy(
                        seriesSeasonsResult = seasons.map {
                            tvShowMapperContainer.tvShowSeasonUIMapper.map(it)
                        },
                        isLoading = false
                    )
                }
                updateDetailItems(TvShowDetailItemUIState.Seasons(_stateUI.value.seriesSeasonsResult))
            } catch (e: Exception) {
            }
        }
    }

    private fun getLoginStatus() {
        if (!sessionIDUseCase().isNullOrEmpty()) {
            _stateUI.update { it.copy(isLogin = true) }
            getRatedTvShows(args.tvShowId)
        }
    }

    private fun getRatedTvShows(tvShowId: Int) {
        viewModelScope.launch {
            try {
                _stateUI.update {
                    it.copy(
                        ratingValue = getTvShowDetailsUseCase.getTvShowRated(
                            tvShowId
                        )
                    )
                }
                updateDetailItems(TvShowDetailItemUIState.Rating(this@TvShowDetailsViewModel))
            } catch (e: Throwable) {
            }
        }
    }

    fun onChangeRating(value: Float) {
        viewModelScope.launch {
            try {
                setRatingUesCase(args.tvShowId, value)
                _stateUI.update { it.copy(ratingValue = value) }
                _tvShowDetailsUIEvent.update { Event(TvShowDetailsUIEvent.MessageAppear) }
            } catch (e: Throwable) {
            }
        }
    }

    private fun getTvShowReviews(tvShowId: Int) {
        viewModelScope.launch {
            try {
                val result = getTvShowDetailsUseCase.getTvShowReviews(tvShowId)
                _stateUI.update {
                    it.copy(
                        seriesReviewsResult = result.reviews.map { review ->
                            tvShowMapperContainer.tvShowReviewUIMapper.map(review)
                        }, isLoading = false
                    )
                }
                if (result.reviews.isNotEmpty()) {
                    setReviews(result.isMoreThanMax)
                }
            } catch (e: Throwable) {
            }
        }
    }

    private fun setReviews(showSeeAll: Boolean) {
        _stateUI.value.seriesReviewsResult
            .forEach { updateDetailItems(TvShowDetailItemUIState.Comment(it)) }
        updateDetailItems(TvShowDetailItemUIState.ReviewText)

        if (showSeeAll) {
            updateDetailItems(TvShowDetailItemUIState.SeeAllReviewsButton)
        }
    }

    private fun updateDetailItems(item: TvShowDetailItemUIState) {
        val list = _stateUI.value.detailItemResult.toMutableList()
        list.add(item)
        _stateUI.update { it.copy(detailItemResult = list.toList()) }
    }

    private suspend fun insertMovieToWatchHistory(tvShow: TvShowDetails) {
        getInsertTvShowUserCase(tvShow)
    }

    override fun onClickSave() {}

    override fun onClickPlayTrailer() {
        _tvShowDetailsUIEvent.update { Event(TvShowDetailsUIEvent.ClickPlayTrailerEvent) }
    }

    override fun onclickBack() {
        this._tvShowDetailsUIEvent.update { Event(TvShowDetailsUIEvent.ClickBackEvent) }
    }

    override fun onclickViewReviews() {
        _tvShowDetailsUIEvent.update { Event(TvShowDetailsUIEvent.ClickReviewsEvent) }
    }

    override fun onClickActor(actorID: Int) {
        _tvShowDetailsUIEvent.update { Event(TvShowDetailsUIEvent.ClickCastEvent(actorID)) }
    }

    override fun onClickSeason(seasonNumber: Int) {
        _tvShowDetailsUIEvent.update { Event(TvShowDetailsUIEvent.ClickSeasonEvent(seasonNumber)) }
    }

}
