package com.example.aflammy.ui.tvShowDetails.episodes


data class EpisodesUIState(
    val seriesEpisodeUIState: List<EpisodeUIState> = listOf(),
    val isLoading: Boolean = false,
    val error: List<com.example.aflammy.ui.tvShowDetails.tvShowUIState.Error> = emptyList()
)
