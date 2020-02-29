package com.example.cse438.cse438_assignment2.fragments


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse438.cse438_assignment2.adapter.PlaylistListAdapter
import com.example.cse438.cse438_assignment2.viewmodels.PlaylistViewModel
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.db.Playlist
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.dialog_create_playlist.*
import kotlinx.android.synthetic.main.dialog_create_playlist.view.*
import kotlinx.android.synthetic.main.fragment_playlist.*


class PlaylistFragment : Fragment() {

    private lateinit var playlistViewModel : PlaylistViewModel
    var _playlistList : ArrayList<Playlist> = ArrayList()
    lateinit var createPlaylistBtn : FloatingActionButton
    lateinit var genreSpinner: Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var plAdapter = PlaylistListAdapter(_playlistList)
        plRecyclerView.adapter = plAdapter
        plRecyclerView.layoutManager = LinearLayoutManager(this.context)
        //plRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        playlistViewModel!!._playlistList.observe(this, Observer { pls ->
            _playlistList.clear()
            _playlistList.addAll(pls)
            plAdapter.notifyDataSetChanged()
        })

        //set the button
        createPlaylistBtn = create_playlist_btn

        //set the create button listener
        create_playlist_btn.setOnClickListener{
            dialogView()
        }
    }

    private fun dialogView() {
        // Opens the dialog view asking the user for their calorie goal for the day
        val dialogView = LayoutInflater.from(this.context).inflate(R.layout.dialog_create_playlist, null)
        val mBuilder = AlertDialog.Builder(this.context)
            .setView(dialogView)
            .setTitle("Enter Playlist Information")
        val mAlertDialog = mBuilder.show()

        genreSpinner=dialogView.findViewById(R.id.plGenreSpinner)
        //Create spinner dropdown
        ArrayAdapter.createFromResource(this.context, R.array.genre_array, android.R.layout.simple_spinner_item).also{
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genreSpinner.adapter = adapter
        }

        // Sets an onclick listener on the dialog box submission button
        mAlertDialog.submitPl.setOnClickListener {
            val playlistName = dialogView.plName.text.toString()
            val playlistDesc = dialogView.plDescription.text.toString()
            val playlistRating = dialogView.plRating.text.toString()
            val playlistGenre = dialogView.plGenreSpinner.selectedItem.toString()
            // If the string is empty, we do not want to accept that as an input
            if(playlistName == "" || playlistDesc == "" || playlistRating == "" || playlistGenre == ""){
                val diaToast = Toast.makeText(this.context, "Please enter all fields", Toast.LENGTH_LONG)
                diaToast.show()
            }
            else if(playlistGenre == "Select a Genre"){
                val diaToast = Toast.makeText(this.context, "Please choose a genre from the dropdown", Toast.LENGTH_LONG)
                diaToast.show()
            }
            else
            {
                val pl = Playlist(
                    playlistName,
                    playlistDesc,
                    playlistRating,
                    playlistGenre
                )

                //add the playlist to the database
                playlistViewModel!!.insertPlaylist(pl)

                val text = "Playlist Added!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(this.context, text, duration)
                toast.show()
                mAlertDialog.dismiss()
            }
        }
    }
}