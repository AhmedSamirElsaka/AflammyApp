package com.example.aflammy.ui.allMedia

import androidx.recyclerview.widget.DiffUtil
import com.example.aflammy.R
import com.example.aflammy.ui.adapters.MediaInteractionListener
import com.example.aflammy.ui.base.BasePagingAdapter
import com.example.aflammy.ui.models.MediaUiState

open class AllMediaAdapter(listener: MediaInteractionListener) :
    BasePagingAdapter<MediaUiState>(MediaComparator, listener) {
    override val layoutID: Int = R.layout.item_media

    object MediaComparator : DiffUtil.ItemCallback<MediaUiState>() {
        override fun areItemsTheSame(oldItem: MediaUiState, newItem: MediaUiState) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MediaUiState, newItem: MediaUiState) =
            oldItem == newItem
    }

}