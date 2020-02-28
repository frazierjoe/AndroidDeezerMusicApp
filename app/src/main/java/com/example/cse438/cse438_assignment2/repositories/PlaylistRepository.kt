package com.example.cse438.cse438_assignment2.repositories

import androidx.lifecycle.LiveData
import com.example.cse438.cse438_assignment2.db.Playlist
import com.example.cse438.cse438_assignment2.db.PlaylistDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PlaylistRepository (private val playlistDao: PlaylistDAO){
    val allPlaylists: LiveData<List<Playlist>> = playlistDao.getPlaylists()

    fun insert(pl: Playlist) {
        CoroutineScope(Dispatchers.IO).launch {
            playlistDao.insert(pl)
        }
    }

    fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            playlistDao.deleteAll()
        }
    }
}