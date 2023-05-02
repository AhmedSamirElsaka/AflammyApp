package com.example.aflammy.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WATCH_HISTORY_TABLE")
data class WatchHistoryEntity(
    @PrimaryKey val id: Int,
    var posterPath: String,
    var movieTitle: String,
    var voteAverage: String,
    var releaseDate: String,
    var movieDuration: Int,
    var mediaType:String
)