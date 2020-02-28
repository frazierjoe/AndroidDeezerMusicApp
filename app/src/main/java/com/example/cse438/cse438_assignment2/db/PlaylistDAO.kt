package com.example.cse438.cse438_assignment2.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlaylistDAO {

    @Query("SELECT * FROM playlists")
    fun getPlaylists(): LiveData<List<Playlist>>

    @Insert
    fun insert(pl: Playlist)

    @Query("DELETE FROM playlists")
    fun deleteAll()
}