package com.example.cse438.cse438_assignment2.network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.TrackPayload
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class PlaylistRepository {
    val service = ApiClient.makePlaylistRetrofitService()

    fun getTracksBySearch(resBody: MutableLiveData<TrackPayload>, album: String, artist: String, genre: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getTracksBySearch(album, artist, genre)

            withContext(Dispatchers.Main) {
                try{
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch (e: HttpException) {
                    println("Http error")
                }
            }
        }
    }
}