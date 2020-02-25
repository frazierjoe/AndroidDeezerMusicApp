package com.example.cse438.cse438_assignment2.data

import retrofit2.http.Url
import java.sql.Date

data class Track(
    val id: Int,
    val readable: Boolean,
    val title: String,
    val title_short: String,
    val title_version: String,
    val unseen: Boolean,
    val isrc: String,
    val link: Url,
    val share: Url,
    val duration: Int,
    val track_position: Int,
    val disk_number: Int,
    val rank: Int,
    val release_date: Date,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    val preview: Url,
    val bpm: Float,
    val gain: Float,
    val available_countries: List<String>,
    val alternative: Track,
    val contributors: List<String>,
    val artist: Artist,
    val album: Album
)

data class Payload (val response_code: Int, val results: List<Track>)