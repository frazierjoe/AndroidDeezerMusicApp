package com.example.cse438.cse438_assignment2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.adapter.GridItemAdapter
import com.example.cse438.cse438_assignment2.data.DisplayObject
import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.db.Playlist
import com.example.cse438.cse438_assignment2.db.Song
import com.example.cse438.cse438_assignment2.viewmodels.PlaylistViewModel
import com.example.cse438.cse438_assignment2.viewmodels.TrackViewModel

class PlaylistActivity: AppCompatActivity() {

    lateinit var trackViewModel: TrackViewModel
    lateinit var playlistViewModel: PlaylistViewModel
    var trackList: ArrayList<Track> = ArrayList()
    var songList: ArrayList<Song> = ArrayList()
    lateinit var thisPlaylist: Playlist
    lateinit var thisTrack: Track
    private lateinit var recyclerView: RecyclerView
    var DisplayObjectList: ArrayList<DisplayObject> = ArrayList()
    private var gridItemAdapter = GridItemAdapter(DisplayObjectList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)


        recyclerView = findViewById(R.id.plTrackRecyclerView)
        recyclerView.adapter = gridItemAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2) //TODO CREATE ADAPTER


        var playlistId: String = intent.getStringExtra("id")

        playlistViewModel = ViewModelProviders.of(this).get(PlaylistViewModel::class.java)
        playlistViewModel!!.songList.observe(this, Observer {
            songList.clear()
            for(song in it){
                songList.add(song)
            }
            getTracks(songList)
        })
        playlistViewModel.getPlaylistSongs(playlistId.toInt())


    }

    fun getTracks(songList: ArrayList<Song>){



        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)
        trackViewModel!!.track.observe(this, Observer {
            trackList.clear()
            trackList.add(it)
            for (track in trackList) {
                DisplayObjectList.add(DisplayObject(track.album.cover_big, track.title, track.artist.name, "Track", null, track, null, track.id.toString()))
            }
            gridItemAdapter.notifyDataSetChanged()
        })
        for(song in songList) {
            trackViewModel.getTrack(song.trackID.toString())
        }
    }

}