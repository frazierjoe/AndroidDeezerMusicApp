package com.example.cse438.cse438_assignment2

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.SearchPayload
import com.example.cse438.cse438_assignment2.network.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class SearchRepository {
    val service = ApiClient.makeSearchRetrofitService()

    fun getSearchResponse(resBody: MutableLiveData<SearchPayload>, query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response  = service.getSearchResponse(query)

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