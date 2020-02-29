package com.example.cse438.cse438_assignment2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.fragments.SearchArtistFragment
import com.example.cse438.cse438_assignment2.fragments.SearchTrackFragment


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var input = intent.getStringExtra("input")
        var type = intent.getStringExtra("type")

        val bundle = Bundle().apply {
            putString("input", input)
        }
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        var fragment: Fragment
        if(type == "Artist") {
            fragment = SearchArtistFragment()
        }
        else{
            fragment = SearchTrackFragment()
        }

        fragment.arguments = bundle
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

}