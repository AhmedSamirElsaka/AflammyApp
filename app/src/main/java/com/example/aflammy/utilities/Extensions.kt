package com.example.aflammy.utilities

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aflammy.data.remote.response.MyListsDto
import com.example.aflammy.data.remote.response.trailerVideosDto.ResultDto
import com.example.aflammy.ui.adapters.LoadUIStateAdapter
import com.example.aflammy.ui.base.BasePagingAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

fun Date.convertToDayMonthYearFormat(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(this)
}

fun List<ResultDto?>.getKey(): String? = this.map {
    if (it?.type == "Trailer") return it.key
}.toString()

fun MyListsDto.checkIfExist(movie_id: Int): Boolean {
    this.items?.map {
        if (it?.id == movie_id) {
            return true
        }
    }
    return false
}

fun <T> LifecycleOwner.collectLast(flow: Flow<T>, action: suspend (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest(action)
        }
    }
}

fun <T> List<T>.margeTowList(secondList: List<T>): List<T> {
    return this.plus(secondList)
}

fun <T> LifecycleOwner.collect(flow: Flow<T>, action: suspend (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect {
                action.invoke(it)
            }
        }
    }
}

fun <T : Any> GridLayoutManager.setSpanSize(
    footerAdapter: LoadUIStateAdapter, adapter: BasePagingAdapter<T>, spanCount: Int
) {
    this.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return if ((position == adapter.itemCount) && footerAdapter.itemCount > 0) {
                spanCount
            } else {
                1
            }
        }
    }
}