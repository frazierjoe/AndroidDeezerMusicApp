package com.example.cse438.cse438_assignment2.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.adapter.PlaylistGridItemAdapter
import com.example.cse438.cse438_assignment2.data.DisplayObject
import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.db.Playlist
import com.example.cse438.cse438_assignment2.db.Song
import com.example.cse438.cse438_assignment2.viewmodels.PlaylistViewModel
import com.example.cse438.cse438_assignment2.viewmodels.SongViewModel
import com.example.cse438.cse438_assignment2.viewmodels.TrackViewModel
import kotlinx.android.synthetic.main.activity_playlist.*
import kotlinx.android.synthetic.main.dialog_remove_playlist.*

class PlaylistActivity: AppCompatActivity() {

    lateinit var trackViewModel: TrackViewModel
    lateinit var songViewModel : SongViewModel
    lateinit var plViewModel : PlaylistViewModel
    lateinit var playlistTitle: String
    lateinit var playlistDescription: String
    lateinit var playlistRating: String
    lateinit var playlistGenre: String
    lateinit var playlistId: String
    lateinit var thisSong: Song
    var trackList: ArrayList<Track> = ArrayList()
    var songList: ArrayList<Song> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    var DisplayObjectList: ArrayList<DisplayObject> = ArrayList()
    private var plGridItemAdapter = PlaylistGridItemAdapter(DisplayObjectList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)

        recyclerView = findViewById(R.id.plTrackRecyclerView)
        recyclerView.adapter = plGridItemAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        //get playlist data
        playlistTitle = intent.getStringExtra("title")
        playlistRating = intent.getStringExtra("rating")
        playlistGenre = intent.getStringExtra("genre")
        playlistDescription = intent.getStringExtra("description")
        playlistId = intent.getStringExtra("id")

        //display data
        var strplaylistRating = "Rating: " + playlistRating
        var strplaylistGenre = "Genre: " + playlistGenre
        thisPlaylistTitle.text = playlistTitle
        thisPlaylistDescription.text = playlistDescription
        thisPlaylistRating.text = strplaylistRating
        thisPlaylistGenre.text = strplaylistGenre


        //observe updates to playlist
        songViewModel = ViewModelProviders.of(this).get(SongViewModel::class.java)
        songViewModel!!.songList.observe(this, Observer {
            songList.clear()
            for (song in it) {
                songList.add(song)
            }
            getTracks(songList)
        })
        songViewModel.getPlaylistSongs(playlistId.toInt())

        //set the create button listener
        remove_playlist_btn.setOnClickListener{
            dialogView()
        }
    }

    //opens dialog box to potentially delete playlist
    private fun dialogView() {
        // Opens the dialog view asking the user for their calorie goal for the day
        val dialogView =
            LayoutInflater.from(this).inflate(R.layout.dialog_remove_playlist, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Delete this Playlist?")
        val mAlertDialog = mBuilder.show()

        //if yes, reconstruct playlist object and delete it
        mAlertDialog.delYes.setOnClickListener {
            plViewModel = ViewModelProviders.of(this).get(PlaylistViewModel::class.java)
            var delPL = Playlist(
                playlistTitle,
                playlistDescription,
                playlistRating,
                playlistGenre
            )
            delPL.id = playlistId.toInt()
            plViewModel.removePlaylist(delPL)
            val intent = Intent(this, MainActivity::class.java).apply {}
            startActivity(intent)
            Toast.makeText(this, "Playlist Deleted", Toast.LENGTH_LONG).show()
        }
        mAlertDialog.delNo.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

    fun getTracks(songList: ArrayList<Song>){
        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)
        trackViewModel!!.track.observe(this, Observer {
            trackList.clear()
            trackList.add(it)
            for (track in trackList) {
                for(song in songList) {
                    if(song.trackID.toInt() == track.id){
                        thisSong = song
                    }
                }
                DisplayObjectList.add(DisplayObject(track.album.cover_big, track.title, track.artist.name, "Track", null, track, null, track.id.toString(), thisSong))
            }
            plGridItemAdapter.notifyDataSetChanged()
        })
        for(song in songList) {
            trackViewModel.getTrack(song.trackID)
        }
    }

}