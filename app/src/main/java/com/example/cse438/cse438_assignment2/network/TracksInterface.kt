package com.example.cse438.cse438_assignment2.network

import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.data.TrackPayload
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface TracksInterface {
    @GET("chart/0/tracks")
    suspend fun getChartTracks(): Response<TrackPayload>

    @GET("search/track")
    suspend fun getSearchTracks(@Query("q") query: String) : Response<TrackPayload>

    @GET("track/{id}")
    suspend fun getTrack(@Path("id") id: String): Response<Track>
}
