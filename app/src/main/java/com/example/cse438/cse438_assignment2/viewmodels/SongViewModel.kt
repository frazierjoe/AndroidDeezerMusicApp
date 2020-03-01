package com.example.cse438.cse438_assignment2.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cse438.cse438_assignment2.db.PlaylistRoomDatabase
import com.example.cse438.cse438_assignment2.db.Song
import com.example.cse438.cse438_assignment2.repositories.SongRepository
import kotlinx.coroutines.launch

class SongViewModel(application: Application): AndroidViewModel(application){
    private val repository: SongRepository
    var songList: MutableLiveData<List<Song>> = MutableLiveData()
    var allSongsList: LiveData<List<Song>> = MutableLiveData()

    init {
        val songDao = PlaylistRoomDatabase.getDatabase(application).songDao()
        repository = SongRepository(songDao)
        allSongsList = repository.allSongs
    }

    fun insertSong(song : Song) = viewModelScope.launch{
        repository.insertSong(song)
    }

    fun removeSong(song: Song) = viewModelScope.launch{
        repository.removeSong(song)
    }

    fun clear() = viewModelScope.launch{
        repository.clear()
    }

    fun getPlaylistSongs(id: Int){
        repository.getPlaylistSongs(songList, id)

    }



}