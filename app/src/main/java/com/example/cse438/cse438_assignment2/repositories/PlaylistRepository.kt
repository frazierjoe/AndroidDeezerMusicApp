package com.example.cse438.cse438_assignment2.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.db.Playlist
import com.example.cse438.cse438_assignment2.db.PlaylistDAO
import com.example.cse438.cse438_assignment2.db.Song
import com.example.cse438.cse438_assignment2.db.SongDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PlaylistRepository (private val playlistDao: PlaylistDAO){
    val allPlaylists: LiveData<List<Playlist>> = playlistDao.getPlaylists()

    fun insertPlaylist(pl: Playlist) {
        CoroutineScope(Dispatchers.IO).launch {
            playlistDao.insertPlaylist(pl)
        }
    }

    fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            playlistDao.deleteAll()
        }
    }
}

