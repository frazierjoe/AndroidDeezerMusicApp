package com.example.cse438.cse438_assignment2.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SingleTrack(
    val id: Int,
    val readable: Boolean,
    val title: String,
    val title_short: String,
    val title_version: String,
    val isrc: String,
    val link: String,
    val share: String,
    val duration: Int,
    val track_position: Int,
    val disk_number: Int,
    val rank: Int,
    val release_date: String,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    val preview: String,
    val bpm: String,
    val gain: String,
    val available_countries:List<String>,

    val artist: Artist,
    val album: Album,
    val type: String
): Parcelable