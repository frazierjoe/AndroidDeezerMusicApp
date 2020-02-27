package com.example.cse438.cse438_assignment2

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.ArtistPayload
import com.example.cse438.cse438_assignment2.network.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class ArtistRepository{
    val service = ApiClient.makeArtistRetrofitService()

    fun getSearchArtist(resBody: MutableLiveData<ArtistPayload>, param: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response  = service.getSearchArtist(param)

//            val response  = service.getSearchTracks()
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