package com.example.cse438.cse438_assignment2.network

import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.data.TrackPayload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TracksInterface {
    @GET("chart/0/tracks")
    suspend fun getChartTracks(): Response<TrackPayload>

    @GET("search/track")
    suspend fun getSearchTracks(@Query("q") query: String) : Response<TrackPayload>

    @GET("track/{id}")
    suspend fun getTrack(@Path("id") id: String): Response<Track>

    @GET("artist/{id}/top?limit=10")
    suspend fun getArtistTopTracks(@Path("id")id: String): Response<TrackPayload>
}
