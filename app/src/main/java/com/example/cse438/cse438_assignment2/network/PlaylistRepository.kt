package com.example.cse438.cse438_assignment2.network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.Payload
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class TriviaRepository {
    val service = ApiClient.makeRetrofitService()

    fun getTracksBySearch(resBody: MutableLiveData<Payload>, album: String, artist: String, genre: String) {
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