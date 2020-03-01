package com.example.cse438.cse438_assignment2.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cse438.cse438_assignment2.repositories.PlaylistRepository
import com.example.cse438.cse438_assignment2.db.Playlist
import com.example.cse438.cse438_assignment2.db.PlaylistRoomDatabase
import kotlinx.coroutines.launch

class PlaylistViewModel(application: Application): AndroidViewModel(application){
    var _playlistList: LiveData<List<Playlist>> = MutableLiveData()
    private val repository: PlaylistRepository


    init {
        val playlistsDao = PlaylistRoomDatabase.getDatabase(application).playlistDao()
        repository =
            PlaylistRepository(playlistsDao)
        _playlistList = repository.allPlaylists

    }

    fun insertPlaylist(playlist: Playlist) = viewModelScope.launch{
        repository.insertPlaylist(playlist)
    }

    fun removePlaylist(pl: Playlist) = viewModelScope.launch{
        repository.removePlaylist(pl)
    }

    fun clear() = viewModelScope.launch{
        repository.clear()
    }


}