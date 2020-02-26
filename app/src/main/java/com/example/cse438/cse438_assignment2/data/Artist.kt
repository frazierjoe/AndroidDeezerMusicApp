package com.example.cse438.cse438_assignment2.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

import retrofit2.http.Url

@Parcelize
data class Artist(
    val id: Int,
    val name: String,
    val link: String,
//    val share: String
    val picture: String,
    val picture_small: String,
    val picture_medium: String,
    val picture_big: String,
    val picture_xl: String,
//    val nb_album: String,
//    val nb_fan: String,
    val radio: Boolean,
//
    val tracklist: String,
    val type: String
): Parcelable