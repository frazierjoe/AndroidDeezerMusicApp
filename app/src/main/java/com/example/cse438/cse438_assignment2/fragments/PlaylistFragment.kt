package com.example.cse438.cse438_assignment2.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.cse438.cse438_assignment2.viewmodels.PlaylistViewModel
import com.example.cse438.cse438_assignment2.R

import kotlinx.android.synthetic.main.fragment_playlist.*


class PlaylistFragment : Fragment() {

    private var playlistViewModel : PlaylistViewModel? = null
    public lateinit var createPlaylistBtn : Button
    public lateinit var inputText : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set the view model
        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)

        //set the buttons and textß
        //createPlaylistBtn = createButton
        //inputText = playlist_text_input

        //set the create button
        create_playlist_btn.setOnClickListener{

        }
    }

}