package com.example.cse438.cse438_assignment2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.db.Song
import com.example.cse438.cse438_assignment2.fragments.GridFragment
import com.example.cse438.cse438_assignment2.fragments.PlaylistFragment
import com.example.cse438.cse438_assignment2.viewmodels.PlaylistViewModel
import com.example.cse438.cse438_assignment2.viewmodels.SongViewModel

import kotlinx.android.synthetic.main.activity_main.*

////android:id="@+id/plalist_item_container"> playllist list row
const val EXTRA_TRACK = "com.example.cse438_assignment2.TRACK"
class MainActivity : AppCompatActivity() {

    private lateinit var playlistViewModel : PlaylistViewModel
    private lateinit var songViewModel: SongViewModel
    lateinit var searchButton: Button
    lateinit var searchBox: EditText
    lateinit var searchSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        songViewModel = ViewModelProvider(this).get(SongViewModel::class.java)
        searchButton=findViewById(R.id.search_button)
        searchBox=findViewById(R.id.search_box)
        searchSpinner=findViewById(R.id.search_spinner)

        if(intent.hasExtra("track id")){

            val pID = intent.getStringExtra("playlist id")
            Toast.makeText(this, pID, Toast.LENGTH_LONG).show()
            val tID = intent.getStringExtra("track id")
            val song = Song(
                tID,
                pID.toInt()
            )
            Log.d("a string", "another")
            songViewModel.insertSong(song)
        }

        //Create spinner dropdown
        ArrayAdapter.createFromResource(this, R.array.search_array, android.R.layout.simple_spinner_item).also{
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            searchSpinner.adapter = adapter
        }

        //Pager adapter, Tabs
        val fragmentAdapter =
            MyPagerAdapter(
                supportFragmentManager
            )
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)


        searchButton.setOnClickListener {
            var input = searchBox.text.toString()
            var type = searchSpinner.selectedItem.toString()
            if (input != ""){

                val intent = Intent(this, SearchActivity::class.java).apply {
                    putExtra("input",input )
                    putExtra("type", type)
                }
                startActivity(intent)

            }
            else{
                Toast.makeText(this, "Please enter a valid search.", Toast.LENGTH_LONG).show()
            }
        }
    }



    class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getCount() : Int {
            return 2
        }

        override fun getItem(position: Int) : Fragment {
            return when (position) {
                0 -> { GridFragment() }
                else -> PlaylistFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when (position) {
                0 -> "Top Tracks"
                else -> "Playlists"
            }
        }
    }
}
