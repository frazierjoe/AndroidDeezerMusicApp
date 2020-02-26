package com.example.cse438.cse438_assignment2.network

import com.example.cse438.cse438_assignment2.data.SingleTrack
import com.example.cse438.cse438_assignment2.data.TrackPayload
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url


interface TracksInterface {
    @GET("chart/0/tracks")
    suspend fun getChartTracks(): Response<TrackPayload>

//    var songId = "0"
//    @GET(@Url String songId)
//    suspend fun getSingleTrack(): Response<Track>
//    @GET("{fullUrl}")
//    fun getSingleTrack(@Path("fullUrl") fullUrl): Response<SingleTrack>
}