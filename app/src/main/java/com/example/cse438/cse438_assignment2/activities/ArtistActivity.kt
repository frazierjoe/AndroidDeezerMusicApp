package com.example.cse438.cse438_assignment2.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.data.Artist
import com.example.cse438.cse438_assignment2.fragments.GridFragment
import com.example.cse438.cse438_assignment2.viewmodels.ArtistViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_artist.*

class ArtistActivity: AppCompatActivity(){

    lateinit var artistViewModel: ArtistViewModel
    var artistList: ArrayList<Artist> = ArrayList()
    lateinit var thisArtist: Artist

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)


        var id: String = intent.getStringExtra("id")

        artistViewModel = ViewModelProviders.of(this).get(ArtistViewModel::class.java)
        artistViewModel!!.artist.observe(this, Observer {
            artistList.clear()
            artistList.add(it)
            Log.d("TAG", it.toString())
            for(artist in artistList){
                updateView(artist)
                thisArtist = artist
            }

        })
        artistViewModel.getArtist(id)

        val fm = supportFragmentManager
        val fmTransaction = fm.beginTransaction()
        val fragment = GridFragment()
        fmTransaction.add(R.id.fragment_container2, fragment)
        fmTransaction.commit()

    }

    fun updateView(artist: Artist){
        artistName.text = artist.name
        var image = artist.picture_big
        Picasso.with(artistImage.context).load(image).into(artistImage)
    }


}