package com.example.cse438.cse438_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cse438.cse438_assignment2.fragments.GridFragment
import com.example.cse438.cse438_assignment2.fragments.PlaylistFragment
import com.example.cse438.cse438_assignment2.SearchViewModel

import kotlinx.android.synthetic.main.activity_main.*

// Store/initial request type and id
// Request Chart, search, track extras
//
//
//
const val EXTRA_TRACK = "com.example.cse438_assignment2.TRACK"
class MainActivity : AppCompatActivity() {

    lateinit var searchButton: SearchView
    lateinit var searchBox: EditText
//    lateinit var searchViewModel: SearchViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton=findViewById(R.id.search_button)
        searchBox=findViewById(R.id.search_box)

        //Pager adapter, Tabs
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)




//        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
//
//
//        searchViewModel!!.searchList.observe(this, Observer {
////            DisplayObjectList.clear()
//            searchList.clear()
////            searchList.addAll(it.data)
//            for(item in searchList){
//                Log.d("Tag", it.total.toString())
//            }
//        })
//
//
//
//        searchButton.setOnSearchClickListener{
//            val input: String = searchBox.text.toString() //Get query parameter
//            Log.d("TAG", "SEARCH BUTTON CLICKED")
//            Log.d("TAG", input)


//            searchViewModel!!.getSearchResponse(input)

//        }


//        searchBox.setOnEditorActionListener{
//            true
//        }


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
