package com.example.aflammy.ui.tvShowDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.aflammy.BR
import com.example.aflammy.R
import com.example.aflammy.ui.adapters.ActorAdapter
import com.example.aflammy.ui.adapters.ActorsInteractionListener
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.movieDetails.DetailInteractionListener
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowDetailItemUIState


class TvShowDetailsUIStateAdapter(
    private var items: List<TvShowDetailItemUIState>,
    private val listener: BaseInteractionListener
) : BaseAdapter<TvShowDetailItemUIState>(items, listener) {
    override val layoutID: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder as ItemViewHolder, position)
    }

    override fun bind(holder: ItemViewHolder, position: Int) {
        when (val currentItem = items[position]) {
            is TvShowDetailItemUIState.Header -> {
                holder.binding.run {
                    setVariable(BR.item, currentItem.data)
                    setVariable(BR.listener, listener as DetailInteractionListener)
                }
            }
            is TvShowDetailItemUIState.Cast -> {
                holder.binding.run {
                    setVariable(
                        BR.adapterRecycler,
                        ActorAdapter(
                            currentItem.data,
                            R.layout.item_cast,
                            listener as ActorsInteractionListener
                        )
                    )
                }
            }
            is TvShowDetailItemUIState.Seasons -> {
                holder.binding.run {
                    setVariable(
                        BR.adapterRecycler,
                        SeasonAdapterUIState(currentItem.data, listener as SeasonInteractionListener)
                    )
                }
            }
            is TvShowDetailItemUIState.Rating -> {
                holder.binding.run {
                    setVariable(BR.viewModel, currentItem.viewModel)
                }
            }
            is TvShowDetailItemUIState.Comment -> {
                holder.binding.run {
                    setVariable(BR.item, currentItem.data)
                    setVariable(BR.listener, listener)
                }
            }
            is TvShowDetailItemUIState.ReviewText -> {}
            TvShowDetailItemUIState.SeeAllReviewsButton -> {
                holder.binding.run {
                    setVariable(BR.listener, listener as DetailInteractionListener)
                }
            }
        }
    }

    override fun setItems(newItems: List<TvShowDetailItemUIState>) {
        items = newItems.sortedBy { it.priority }
        super.setItems(items)
    }

    override fun areItemsSame(oldItem: TvShowDetailItemUIState, newItem: TvShowDetailItemUIState): Boolean {
        return oldItem.priority == newItem.priority
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is TvShowDetailItemUIState.Header -> R.layout.item_tv_show_details_header
            is TvShowDetailItemUIState.Cast -> R.layout.list_cast
            is TvShowDetailItemUIState.Seasons -> R.layout.list_season
            is TvShowDetailItemUIState.Rating -> R.layout.item_tvshow_rating
            is TvShowDetailItemUIState.Comment -> R.layout.item_tvshow_review
            is TvShowDetailItemUIState.ReviewText -> R.layout.item_review_text
            TvShowDetailItemUIState.SeeAllReviewsButton -> R.layout.item_see_all_reviews
        }
    }
}
