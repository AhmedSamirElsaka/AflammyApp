package com.example.aflammy.ui.myList

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.aflammy.R
import com.example.aflammy.databinding.FragmentMyListsBinding
import com.example.aflammy.ui.base.BaseFragment
import com.example.aflammy.ui.myList.myListUIState.MyListUIEvent
import com.example.aflammy.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyListsFragment : BaseFragment<FragmentMyListsBinding>() {

    override val fragmentLayoutId: Int = R.layout.fragment_my_lists
    override val viewModel: MyListsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.myList))
        binding.savedList.adapter = CreatedListAdapter(emptyList(), viewModel)
        collectEvent()
    }

    private fun collectEvent() {
        collectLast(viewModel.myListUIEvent) {
            it.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: MyListUIEvent) {
        var action: NavDirections? = null
        when (event) {
            MyListUIEvent.CreateButtonClicked -> {
                action = MyListsFragmentDirections.actionMyListFragmentToCreateSavedList()
            }
            is MyListUIEvent.DisplayError -> {
                Toast.makeText(requireContext(), event.errorMessage, Toast.LENGTH_LONG).show()
            }
            is MyListUIEvent.OnSelectItem -> {
                action = MyListsFragmentDirections.actionMyListFragmentToSavedListFragment(
                    event.createdListUIState.listID,
                    event.createdListUIState.name
                )
            }
            else -> {
            }
        }
        action?.let { findNavController().navigate(it) }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getData()
    }

}