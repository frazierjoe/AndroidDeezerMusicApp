package com.example.cse438.cse438_assignment2.data

import retrofit2.http.Url
import java.sql.Date

data class Album(
    val id: Int,
    val title: String,
    val upc: String,
    val link: Url,
    val share: Url,
    val cover: Url,
    val cover_small: Url,
    val cover_medium: Url,
    val cover_big: Url,
    val cover_xl: Url,
    val genre_id: Int,
    val genres: List<Genre>,
    val label: String,
    val nb_tracks: Int,
    val duration: Int,
    val fans: Int,
    val rating: Int,
    val release_date: Date,
    val record_type: String,
    val available: Boolean,
    val alternative: Album,
    val tracklist: Url,
    val explicit_lyrics: Boolean,
    val explicit_content: Int,
    val explicit_content_cover: Int,
    val contributors: List<String>,
    val artist: Artist
)