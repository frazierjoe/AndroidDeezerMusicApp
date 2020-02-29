package com.example.cse438.cse438_assignment2.network

import com.example.cse438.cse438_assignment2.data.Artist
import com.example.cse438.cse438_assignment2.data.ArtistPayload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtistInterface {
    @GET("search/artist")
    suspend fun getSearchArtist(@Query("q") query: String) : Response<ArtistPayload>

    @GET("artist/{id}")
    suspend fun getArtist(@Path("id") id: String): Response<Artist>
}