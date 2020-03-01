package com.example.cse438.cse438_assignment2.repositories

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.data.TrackPayload
import com.example.cse438.cse438_assignment2.network.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class TracksRepository {
    val service =
        ApiClient.makeTracksRetrofitService()

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
    fun getSearchTracks(resBody: MutableLiveData<TrackPayload>, param: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response  = service.getSearchTracks(param)

            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        println(response.body()?.toString() + " is the size")
                        resBody.value = response.body()
                    }
                } catch (e: HttpException){
                    println("Http Error")
                } catch (e: Throwable) {
                    //error
                    println("Error")
                }
            }
        }
    }
    fun getTrack(resBody: MutableLiveData<Track>, param: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response  = service.getTrack(param)

            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        println(response.body()?.toString() + " is the size")
                        resBody.value = response.body()
                    }
                } catch (e: HttpException){
                    println("Http Error")
                } catch (e: Throwable) {
                    //error
                    println("Error")
                }
            }
        }
    }
    fun getArtistTopTracks(resBody: MutableLiveData<TrackPayload>, param: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response  = service.getArtistTopTracks(param)

            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        println(response.body()?.toString() + " is the size")
                        resBody.value = response.body()
                    }
                } catch (e: HttpException){
                    println("Http Error")
                } catch (e: Throwable) {
                    //error
                    println("Error")
                }
            }
        }
    }
}