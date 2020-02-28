package com.example.cse438.cse438_assignment2.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.cse438.cse438_assignment2.PlaylistViewModel
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.db.Playlist
import kotlinx.android.synthetic.main.fragment_playlist_form.*
import kotlinx.android.synthetic.main.fragment_playlist_form.view.*



class PlaylistFormFragment : Fragment() {
    private var plViewModel: PlaylistViewModel? = null
    private var trackList : ArrayList<Track> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist_form, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        plViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)

        view.createButton.setOnClickListener { view ->
            val pl = Playlist(
                plDescription.text.toString(),
                plName.text.toString()
            )
            plViewModel!!.insert(pl)

            val text = "Playlist Created!"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(this.context, text, duration)
            toast.show()
        }
    }
}
