package com.example.cse438.cse438_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cse438.cse438_assignment2.fragments.GridFragment
import com.example.cse438.cse438_assignment2.fragments.PlaylistFragment

import kotlinx.android.synthetic.main.activity_main.*


const val EXTRA_TRACK = "com.example.cse438_assignment2.TRACK"
class MainActivity : AppCompatActivity() {

    lateinit var searchButton: Button
    lateinit var searchBox: EditText
    lateinit var searchSpinner: Spinner




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton=findViewById(R.id.search_button)
        searchBox=findViewById(R.id.search_box)
        searchSpinner=findViewById(R.id.search_spinner)


        //Create spinner dropdown
        ArrayAdapter.createFromResource(this, R.array.search_array, android.R.layout.simple_spinner_item).also{
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            searchSpinner.adapter = adapter
        }

        //Pager adapter, Tabs
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)


        searchButton.setOnClickListener {
            var input = searchBox.text.toString()
            var type = searchSpinner.selectedItem.toString()
            if (input != ""){
                Toast.makeText(this, input + " "+ type, Toast.LENGTH_LONG).show()

                val intent = Intent(this, SearchActivity::class.java).apply {
                    putExtra("input",input )
                    putExtra("type", type)
                }
                startActivity(intent)

            }
            else{
                Toast.makeText(this, "Please enter a vaild search.", Toast.LENGTH_LONG).show()
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
                0 -> "Home"
                else -> "Playlists"
            }
        }


    }



}
