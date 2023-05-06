package com.example.aflammy.ui.myList.listDetails.listDetailsUIState

sealed interface ListDetailsUIEvent {
    data class OnItemSelected(val savedMediaUIState: SavedMediaUIState) : ListDetailsUIEvent
}