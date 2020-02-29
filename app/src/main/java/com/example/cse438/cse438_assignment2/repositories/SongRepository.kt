package com.example.cse438.cse438_assignment2.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.db.Song
import com.example.cse438.cse438_assignment2.db.SongDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongRepository (private val songDao: SongDAO){
    var playlistSongs: LiveData<List<Song>> = MutableLiveData()

    var allSongs: LiveData<List<Song>> = songDao.getSongs()


    fun getPlaylistSongs(id: Int): LiveData<List<Song>> {
        CoroutineScope(Dispatchers.IO).launch {
            playlistSongs= songDao.getPlaylistSongs(id)
        }
        return playlistSongs
    }

    fun insertSong(song: Song) {
        CoroutineScope(Dispatchers.IO).launch {
            songDao.insertSong(song)
        }
    }

    fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            songDao.deleteAll()
        }
    }

}