package com.example.cse438.cse438_assignment2.network

import com.example.cse438.cse438_assignment2.data.SearchPayload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchInterface {
    @GET("search")
    suspend fun getSearchResponse(@Query("query")query: String): Response<SearchPayload>
}