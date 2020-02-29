package com.example.cse438.cse438_assignment2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "playlists")
data class Playlist(
    @ColumnInfo(name="title")
    var title: String,
    @ColumnInfo(name="description")
    var description: String,
    @ColumnInfo(name="rating")
    var rating:String,
    @ColumnInfo(name="genre")
    var  genre: String

){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
