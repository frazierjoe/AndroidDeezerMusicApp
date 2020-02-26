package com.example.cse438.cse438_assignment2.network

import com.example.cse438.cse438_assignment2.data.TrackPayload
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET

interface TracksInterface {
    @GET("chart/0/tracks")
    suspend fun getChartTracks(): Response<TrackPayload>
}