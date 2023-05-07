package com.example.aflammy.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.aflammy.R
import com.example.aflammy.databinding.FragmentHomeBinding
import com.example.aflammy.ui.base.BaseFragment
import com.example.aflammy.ui.home.adapters.HomeAdapter
import com.example.aflammy.ui.home.models.HomeUIEvent
import com.example.aflammy.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val fragmentLayoutId: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(false)
        setAdapter()
        collectEvent()
        collectHomeData()
    }

    private fun collectHomeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.homeUiState.collect {
                homeAdapter.setItems(
                    mutableListOf(
                        it.popularMovies,
                        it.tvShowsSeries,
                        it.onTheAiringSeries,
                        it.airingTodaySeries,
                        it.upcomingMovies,
                        it.nowStreamingMovies,
                        it.mysteryMovies,
                        it.adventureMovies,
                        it.trendingMovies,
                        it.actors,
                    )
                )
            }
        }
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter(mutableListOf(), viewModel)
        binding.homeRecyclerView.adapter = homeAdapter
    }
    private fun collectEvent() {
        this.collectLast(viewModel.homeUIEvent) {
            it.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }


    private fun onEvent(event: HomeUIEvent) {
        val action = when (event) {
            is HomeUIEvent.ClickActorEvent -> {
                HomeFragmentDirections.actionHomeFragmentToActorDetailsFragment(
                    event.actorID
                )
            }
            is HomeUIEvent.ClickMovieEvent -> {
                HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
                    event.movieID
                )
            }
            HomeUIEvent.ClickSeeAllActorEvent -> {
                HomeFragmentDirections.actionHomeFragmentToActorsFragment()
            }
            is HomeUIEvent.ClickSeeAllMovieEvent -> {
                HomeFragmentDirections.actionHomeFragmentToAllMovieFragment(
                    -1, event.mediaType
                )
            }
            is HomeUIEvent.ClickSeeAllTVShowsEvent -> {
                HomeFragmentDirections.actionHomeFragmentToAllMovieFragment(
                    -1,
                    event.mediaType
                )
            }
            is HomeUIEvent.ClickSeriesEvent -> {
                HomeFragmentDirections.actionHomeFragmentToTvShowDetailsFragment(
                    event.seriesID
                )
            }
        }
        findNavController().navigate(action)
    }

}