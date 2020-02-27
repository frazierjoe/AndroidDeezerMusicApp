package com.example.cse438.cse438_assignment2.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    const val BASE_URL = "https://api.deezer.com/"

    fun makePlaylistRetrofitService(): PlaylistInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(PlaylistInterface::class.java)

    }
    fun makeTracksRetrofitService(): TracksInterface{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()) //Use moshi converter to convert json to kotlin objects
            .build().create(TracksInterface::class.java)
    }
    fun makeSearchRetrofitService(): SearchInterface{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()) //Use moshi converter to convert json to kotlin objects
            .build().create(SearchInterface::class.java)
    }

}