package com.example.aflammy.ui.movieDetails.saveMovie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.aflammy.R
import com.example.aflammy.databinding.DialogSaveMovieBinding
import com.example.aflammy.ui.base.BaseDialogFragment
import com.example.aflammy.ui.movieDetails.saveMovie.uiState.SaveMovieUIEvent
import com.example.aflammy.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SaveMovieDialog : BaseDialogFragment<DialogSaveMovieBinding>() {

    override val layoutIdFragment = R.layout.dialog_save_movie
    override val viewModel: SaveMovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveListRecyclerView.adapter = SaveListAdapter(mutableListOf(), viewModel)
        collectLast(viewModel.saveMovieUIEvent) {
            it.getContentIfNotHandled()?.let { onEvent(it) }

        }
    }

    private fun onEvent(event: SaveMovieUIEvent) {
        if (event is SaveMovieUIEvent.DisplayMessage) {
            if (!event.message.isNullOrBlank()) {
                Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                dismiss()
            }
        }
    }

}