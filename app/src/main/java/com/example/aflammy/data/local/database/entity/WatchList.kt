package com.example.aflammy.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WATCH_LIST_TABLE")
data class WatchList(
    @PrimaryKey(autoGenerate = false) val id: Long = 0,
    var itemCount: Int,
    var listName: String,
    var posterPath: String,
)