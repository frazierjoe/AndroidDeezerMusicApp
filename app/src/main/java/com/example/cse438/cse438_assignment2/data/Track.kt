package com.example.cse438.cse438_assignment2.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import retrofit2.http.Url
import java.sql.Date



data class Track(
    val id: Int,
    val title: String,
    val title_short: String,
    val title_version: String,
    val link: String,
    val duration: Int,
    val rank: Int,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    val preview: String,
    val position: Int,
    val artist: Artist,
    val album: Album,
    val type: String
//    val readable: Boolean
//    val unseen: Boolean,
//    val isrc: String,
//
//    val share: Url,
//
//    val track_position: Int,
//    val disk_number: Int,
//
//    val release_date: Date,
//
//
//
//    val bpm: Float,
//    val gain: Float,
//    val available_countries: List<String>,
//    val alternative: Track,
//    val contributors: List<String>,
//
//    val album: Album
){
    fun toParcelizeTrack(t: Track):parcelizeTrack{
        return parcelizeTrack(t.id, t.title,t.title_short, t.title_version, t.link, t.duration, t.rank, t.explicit_lyrics, t.explicit_content_lyrics, t.explicit_content_cover, t.preview, t.position, t.artist, t.album, t.type)
    }
}

data class TrackPayload (
    val data: List<Track>,
    val total: Int
)

@Parcelize
data class parcelizeTrack(
    val id: Int,
    val title: String,
    val title_short: String,
    val title_version: String,
    val link: String,
    val duration: Int,
    val rank: Int,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    val preview: String,
    val position: Int,
    val artist: Artist,
    val album: Album,
    val type: String


):Parcelable {

    fun toTrack(t: parcelizeTrack): Track{
        return Track(t.id, t.title,t.title_short, t.title_version, t.link, t.duration, t.rank, t.explicit_lyrics, t.explicit_content_lyrics, t.explicit_content_cover, t.preview, t.position, t.artist, t.album, t.type)
    }
}




