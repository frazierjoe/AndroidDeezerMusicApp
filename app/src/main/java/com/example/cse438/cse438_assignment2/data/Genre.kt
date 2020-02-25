package com.example.cse438.cse438_assignment2.data

import retrofit2.http.Url

data class Genre(
    val id: Int,
    val name: String,
    val picture: Url,
    val picture_small: Url,
    val picture_medium: Url,
    val picture_big: Url,
    val picture_xl: Url
)