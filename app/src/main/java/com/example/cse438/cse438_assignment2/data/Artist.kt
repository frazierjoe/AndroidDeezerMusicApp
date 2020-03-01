package com.example.cse438.cse438_assignment2.data


data class Artist(
    val id: Int,
    val name: String,
    val link: String,
    val picture: String,
    val picture_small: String,
    val picture_medium: String,
    val picture_big: String,
    val picture_xl: String,
    val radio: Boolean,
    val tracklist: String,
    val type: String
)

data class ArtistPayload(
    val data: List<Artist>,
    val total: Int
)

