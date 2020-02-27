package com.example.cse438.cse438_assignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.data.parcelizeTrack
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_track.*

class TrackActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)
        var parcelizedTrack: parcelizeTrack = intent.getParcelableExtra(EXTRA_TRACK)
        updateView(parcelizedTrack.toTrack(parcelizedTrack))
    }

    fun updateView(track: Track){
        trackTitle.text = track.title
        trackArtist.text = track.artist.name
        trackAlbum.text = track.album.title
        trackDuration.text = track.duration.toString()

        var image = track.album.cover_xl
        Picasso.with(trackImage.context).load(image).into(trackImage)
    }

}