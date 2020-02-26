package com.example.cse438.cse438_assignment2.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.TrackPayload
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class TracksRepository {
    val service = ApiClient.makeTracksRetrofitService()

    fun getChartTracks(resBody: MutableLiveData<TrackPayload>){
        CoroutineScope(Dispatchers.IO).launch {
            val response  = service.getChartTracks()

            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        resBody.value = response.body()
                    }
                } catch (e: HttpException){
                    println("Http Error")
                }
            }
        }
    }
}