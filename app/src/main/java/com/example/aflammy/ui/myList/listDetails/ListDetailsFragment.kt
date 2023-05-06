package com.example.aflammy.ui.myList.listDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aflammy.R
import com.example.aflammy.databinding.FragmentListDetailsBinding
import com.example.aflammy.ui.base.BaseFragment
import com.example.aflammy.ui.myList.listDetails.listDetailsUIState.ListDetailsUIEvent
import com.example.aflammy.utilities.Constants
import com.example.aflammy.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListDetailsFragment : BaseFragment<FragmentListDetailsBinding>() {
    override val fragmentLayoutId = R.layout.fragment_list_details
    override val viewModel: ListDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, viewModel.args.listName)
        binding.lists.adapter = ListDetailsAdapter(mutableListOf(), viewModel)
        collectLast(viewModel.listDetailsUIEvent) {
            it.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: ListDetailsUIEvent) {
        if (event is ListDetailsUIEvent.OnItemSelected) {
            if (event.savedMediaUIState.mediaType == Constants.MOVIE) {
                navigateToMovieDetails(event.savedMediaUIState.mediaID)
            } else {
                navigateToTvShowDetails(event.savedMediaUIState.mediaID)
            }
        }
    }

    private fun navigateToMovieDetails(id: Int) {
        findNavController().navigate(
            ListDetailsFragmentDirections.actionSavedListFragmentToMovieDetailFragment(id)
        )
    }

    private fun navigateToTvShowDetails(id: Int) {
        findNavController().navigate(
            ListDetailsFragmentDirections.actionListDetailsFragmentToTvShowDetailsFragment(id)
        )
    }

}