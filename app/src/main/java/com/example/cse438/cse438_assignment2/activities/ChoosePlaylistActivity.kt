package com.example.cse438.cse438_assignment2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.adapter.ChoosePlaylistAdapter
import com.example.cse438.cse438_assignment2.db.Playlist
import com.example.cse438.cse438_assignment2.viewmodels.PlaylistViewModel
import kotlinx.android.synthetic.main.activity_choose_playlist.*


class ChoosePlaylistActivity : AppCompatActivity() {

    private lateinit var playlistViewModel : PlaylistViewModel
    var _playlistList : ArrayList<Playlist> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_playlist)
        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        var trackID = intent.getStringExtra("track ID")

        var choosePlAdapter = ChoosePlaylistAdapter(_playlistList, trackID)
        chooseRecyclerView.adapter = choosePlAdapter
        chooseRecyclerView.layoutManager = LinearLayoutManager(this)

        playlistViewModel!!._playlistList.observe(this, Observer { pls ->
            _playlistList.clear()
            _playlistList.addAll(pls)
            choosePlAdapter.notifyDataSetChanged()
        })
    }
}