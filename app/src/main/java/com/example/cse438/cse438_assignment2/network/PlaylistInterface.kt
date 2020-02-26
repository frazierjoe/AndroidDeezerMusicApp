package com.example.cse438.cse438_assignment2.network


import com.example.cse438.cse438_assignment2.data.TrackPayload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaylistInterface {

    @GET("api.php")
    suspend fun getTracksBySearch(@Query("album") album: String, @Query("artist") artist: String, @Query("genre") genre: String) : Response<TrackPayload>

    @GET("chart/0/tracks")
    suspend fun getChartTracks(): Response<TrackPayload>
}