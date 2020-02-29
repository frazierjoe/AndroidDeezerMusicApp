package com.example.cse438.cse438_assignment2.activities

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.adapter.GridItemAdapter
import com.example.cse438.cse438_assignment2.adapter.PlaylistGridItemAdapter
import com.example.cse438.cse438_assignment2.data.DisplayObject
import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.db.Playlist
import com.example.cse438.cse438_assignment2.db.Song
import com.example.cse438.cse438_assignment2.viewmodels.PlaylistViewModel
import com.example.cse438.cse438_assignment2.viewmodels.SongViewModel
import com.example.cse438.cse438_assignment2.viewmodels.TrackViewModel
import kotlinx.android.synthetic.main.activity_playlist.*

class PlaylistActivity: AppCompatActivity() {

    lateinit var trackViewModel: TrackViewModel
    lateinit var playlistViewModel: PlaylistViewModel
    lateinit var songViewModel : SongViewModel
    var trackList: ArrayList<Track> = ArrayList()
    var songList: ArrayList<Song> = ArrayList()
    lateinit var thisPlaylist: Playlist
    lateinit var thisTrack: Track
    private lateinit var recyclerView: RecyclerView
    var DisplayObjectList: ArrayList<DisplayObject> = ArrayList()
    private var plGridItemAdapter = PlaylistGridItemAdapter(DisplayObjectList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)



        recyclerView = findViewById(R.id.plTrackRecyclerView)
        recyclerView.adapter = plGridItemAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2) //TODO CREATE ADAPTER

        var playlistTitle: String = intent.getStringExtra("title")
        var playlistRating: String = intent.getStringExtra("rating")
        var playlistGenre: String = intent.getStringExtra("genre")
        var playlistDescription: String = intent.getStringExtra("description")
        var playlistId: String = intent.getStringExtra("id")

        playlistRating = "Rating: " + playlistRating
        playlistGenre = "Genre: " + playlistGenre
        thisPlaylistTitle.text = playlistTitle
        thisPlaylistDescription.text = playlistDescription
        thisPlaylistRating.text = playlistRating
        thisPlaylistGenre.text = playlistGenre


        songViewModel = ViewModelProviders.of(this).get(SongViewModel::class.java)
//        songViewModel!!.songList.observe(this, Observer {
//            songList.clear()
//            Log.d("TAG----------VIEW MODEL", "OBSERVER")
//            for(song in it){
//                songList.add(song)
//                Log.d("TAG__________________", song.playlistID.toString())
//            }
//            getTracks(songList)
//        })
////        songViewModel.getPlaylistSongs(playlistId.toInt())
//        songViewModel.getSon

        songViewModel!!.allSongsList.observe(this, Observer {
            songList.clear()
            for (song in it){
                songList.add(song)
            }
            getTracks(songList)
        })


    }

    fun getTracks(songList: ArrayList<Song>){

        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)
        trackViewModel!!.track.observe(this, Observer {
            trackList.clear()
            trackList.add(it)
            for (track in trackList) {
                DisplayObjectList.add(DisplayObject(track.album.cover_big, track.title, track.artist.name, "Track", null, track, null, track.id.toString()))
            }
            plGridItemAdapter.notifyDataSetChanged()
        })
        for(song in songList) {
            trackViewModel.getTrack(song.trackID.toString())
        }
    }

}