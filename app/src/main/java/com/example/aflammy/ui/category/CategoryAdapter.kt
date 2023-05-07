package com.example.aflammy.ui.category

import androidx.recyclerview.widget.DiffUtil
import com.example.aflammy.R
import com.example.aflammy.ui.adapters.MediaInteractionListener
import com.example.aflammy.ui.base.BasePagingAdapter
import com.example.aflammy.ui.category.uiState.CategoryMediaUIState

class CategoryAdapter (listener: MediaInteractionListener) :
    BasePagingAdapter<CategoryMediaUIState>(MediaComparator, listener) {
    override val layoutID: Int = R.layout.item_category

    object MediaComparator : DiffUtil.ItemCallback<CategoryMediaUIState>() {
        override fun areItemsTheSame(oldItem: CategoryMediaUIState, newItem: CategoryMediaUIState) =
            oldItem.mediaID == newItem.mediaID

        override fun areContentsTheSame(oldItem: CategoryMediaUIState, newItem: CategoryMediaUIState) =
            oldItem == newItem
    }

}
