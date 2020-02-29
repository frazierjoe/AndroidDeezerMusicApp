package com.example.cse438.cse438_assignment2.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.viewmodels.TrackViewModel
import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.db.Song
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_track.*

class PlaylistTrackActivity: AppCompatActivity(){

    lateinit var trackViewModel: TrackViewModel
    var trackList: ArrayList<Track> = ArrayList()
    lateinit var thisTrack: Track
    lateinit var tID : String


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_track)

        tID = intent.getStringExtra("id")

        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)
        trackViewModel!!.track.observe(this, Observer {
            trackList.clear()
            trackList.add(it)
            Log.d("TAG", it.toString())
            for(track in trackList){
                updateView(track)
                thisTrack = track
            }
        })
        trackViewModel.getTrack(tID)
    }


    fun updateView(track: Track){
        trackTitle.text = track.title
        trackArtist.text = track.artist.name
        trackAlbum.text = track.album.title
        trackDuration.text = track.duration.toString()
        trackReleased.text = track.release_date
        trackRank.text = track.rank.toString()
        trackPosition.text = track.track_position.toString()

        var image = track.album.cover_xl
        Picasso.with(trackImage.context).load(image).into(trackImage)
    }


    fun removeFromPlaylist(v: View){
        Toast.makeText(this, thisTrack.title, Toast.LENGTH_LONG).show()
        val intent = Intent(this, ChoosePlaylistActivity::class.java).apply {
            putExtra("track ID", tID)
        }
        startActivity(intent)
    }
}