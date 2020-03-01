package com.example.cse438.cse438_assignment2.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.db.Song
import com.example.cse438.cse438_assignment2.db.SongDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SongRepository (private val songDao: SongDAO){

    var allSongs: LiveData<List<Song>> = songDao.getSongs()


    fun getPlaylistSongs(resBody: MutableLiveData<List<Song>>, id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            var response = songDao.getPlaylistSongs(id)
            withContext(Dispatchers.Main){
                try{
                    if(response != null){
                        println(response.toString() + " is the size")
                        resBody.value = response
                    }
                } catch (e: Throwable) {
                    //error
                    println("Error")
                }
            }
        }

    }

    fun insertSong(song: Song) {
        CoroutineScope(Dispatchers.IO).launch {
            songDao.insertSong(song)
        }
    }

    fun removeSong(song: Song) {
        CoroutineScope(Dispatchers.IO).launch {
            songDao.removeSong(song)
        }
    }

    fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            songDao.deleteAll()
        }
    }

}