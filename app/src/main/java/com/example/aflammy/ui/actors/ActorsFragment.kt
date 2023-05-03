package com.example.aflammy.ui.actors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aflammy.R
import com.example.aflammy.databinding.FragmentActorsBinding
import com.example.aflammy.ui.actors.models.ActorsUIEvent
import com.example.aflammy.ui.adapters.LoadUIStateAdapter
import com.example.aflammy.ui.base.BaseFragment
import com.example.aflammy.ui.models.ActorUiState
import com.example.aflammy.utilities.collect
import com.example.aflammy.utilities.collectLast
import com.example.aflammy.utilities.setSpanSize
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActorsFragment : BaseFragment<FragmentActorsBinding>() {
    override val fragmentLayoutId: Int = R.layout.fragment_actors
    override val viewModel:ActorsViewModel by viewModels()

    private val actorsAdapter by lazy { ActorsAdapter(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, resources.getString(R.string.actors))
        setAdapter()
        collectEvent()
    }
    private fun setAdapter() {
        val footerAdapter = LoadUIStateAdapter(actorsAdapter::retry)
        binding.recyclerViewActors.adapter = actorsAdapter.withLoadStateFooter(footerAdapter)

        val mManager = binding.recyclerViewActors.layoutManager as GridLayoutManager
        mManager.setSpanSize(footerAdapter, actorsAdapter, mManager.spanCount)

        collect(flow = actorsAdapter.loadStateFlow,
            action = { viewModel.setErrorUiState(it) })

        collectLast(viewModel.uiState.value.actors, ::setAllActors)
    }

    private suspend fun setAllActors(itemsPagingData: PagingData<ActorUiState>) {
        actorsAdapter.submitData(itemsPagingData)
    }

    private fun collectEvent() {
        collectLast(viewModel.actorsUIEventFlow) {
            it?.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: ActorsUIEvent) {
        when (event) {
            is ActorsUIEvent.ActorEvent -> {
                findNavController().navigate(
                    ActorsFragmentDirections.actionActorsFragmentToActorDetailsFragment(
                        event.actorID
                    )
                )
            }
            ActorsUIEvent.RetryEvent -> {
                actorsAdapter.retry()
            }
        }
    }

}