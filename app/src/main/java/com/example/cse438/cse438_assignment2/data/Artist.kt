package com.example.cse438.cse438_assignment2.data

import retrofit2.http.Url

data class Artist(
    val id: Int,
    val name: String,
    val link: Url,
    val share: Url,
    val picture: Url,
    val picture_small: Url,
    val picture_medium: Url,
    val picture_big: Url,
    val picture_xl: Url,
    val nb_album: String,
    val nb_fan: String,
    val radio: Boolean,
    val tracklist: Url
)