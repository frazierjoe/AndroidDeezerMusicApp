package com.example.cse438.cse438_assignment2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cse438.cse438_assignment2.data.Genre
import com.example.cse438.cse438_assignment2.data.Track

@Entity(tableName = "playlists")
data class Playlist(
    @ColumnInfo(name="title")
    var title: String,
    @ColumnInfo(name="description")
    var description: String,
    @ColumnInfo(name="tracks")
    val tracks: List<Track>
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}