package com.example.cse438.cse438_assignment2.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cse438.cse438_assignment2.repositories.PlaylistRepository
import com.example.cse438.cse438_assignment2.db.Playlist
import com.example.cse438.cse438_assignment2.db.PlaylistRoomDatabase
import com.example.cse438.cse438_assignment2.db.Song
import kotlinx.coroutines.launch

class PlaylistViewModel(application: Application): AndroidViewModel(application){
    var _playlistList: LiveData<List<Playlist>> = MutableLiveData()
    private val repository: PlaylistRepository
    var songList: LiveData<List<Song>> = MutableLiveData()

    init {
        val playlistsDao = PlaylistRoomDatabase.getDatabase(application).playlistDao()
        repository =
            PlaylistRepository(playlistsDao)
        _playlistList = repository.allPlaylists

    }
    fun getPlaylists() : LiveData<List<Playlist>> {
        return _playlistList
    }

    fun insertPlaylist(playlist: Playlist) = viewModelScope.launch{
        repository.insertPlaylist(playlist)
    }

    fun insertSong(song : Song) = viewModelScope.launch{
        repository.insertSong(song)
    }

    fun clear() = viewModelScope.launch{
        repository.clear()
    }

    fun getPlaylistSongs(id: Int): LiveData<List<Song>>{
        songList = repository.getPlaylistSongs(id) //TODO
        return songList
    }

}