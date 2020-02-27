package com.example.cse438.cse438_assignment2.network

import com.example.cse438.cse438_assignment2.data.ArtistPayload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistInterface {
    @GET("search/artist")
    suspend fun getSearchArtist(@Query("q") query: String) : Response<ArtistPayload>
}