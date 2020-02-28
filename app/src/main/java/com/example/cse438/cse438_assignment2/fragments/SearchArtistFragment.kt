package com.example.cse438.cse438_assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.ArtistViewModel
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.adapter.GridItemAdapter
import com.example.cse438.cse438_assignment2.data.Artist
import com.example.cse438.cse438_assignment2.data.DisplayObject

class SearchArtistFragment : Fragment(){
    lateinit var artistViewModel: ArtistViewModel
    private lateinit var recyclerView: RecyclerView

    var artistList:ArrayList<Artist> = ArrayList()
    var DisplayObjectList: ArrayList<DisplayObject> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{

        var input  = this.arguments!!.getString("input")

        val rootView = inflater.inflate(R.layout.fragment_grid, container, false)
        recyclerView = rootView.findViewById(R.id.recyclerView) as RecyclerView

        artistViewModel = ViewModelProviders.of(this).get(ArtistViewModel::class.java)

        var gridItemAdapter = GridItemAdapter(DisplayObjectList)
        recyclerView.adapter = gridItemAdapter
        recyclerView.layoutManager = GridLayoutManager(activity, 2)

        artistViewModel!!.artistList.observe(this, Observer {
            DisplayObjectList.clear()
            artistList.clear()
            artistList.addAll(it.data)
            for(artist in artistList){
                DisplayObjectList.add(DisplayObject(artist.picture_big, artist.name, "", "Artist", artist, null, null, artist.id.toString()))
            }
            gridItemAdapter.notifyDataSetChanged()
        })
        artistViewModel.getSearchArtist(input)
        return rootView

    }

}