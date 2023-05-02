package com.example.aflammy.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract    class BaseViewModel : ViewModel() {

    fun wrapWithState(function: suspend () -> Unit, errorFunction: (e: Throwable) -> Unit = {}) {
        viewModelScope.launch {
            try {
                function()
            } catch (e: Throwable) {
                errorFunction(e)
            }
        }
    }

    fun <T> collectData(
        data: Flow<List<T>>,
        function: suspend (List<T>) -> Unit
    ) {
        viewModelScope.launch {
            data.collect {
                function(it)
            }
        }
    }

    abstract fun getData()

}