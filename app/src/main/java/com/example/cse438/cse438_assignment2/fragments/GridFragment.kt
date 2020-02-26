package com.example.cse438.cse438_assignment2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.TrackViewModel
import com.example.cse438.cse438_assignment2.adapter.GridItemAdapter
import com.example.cse438.cse438_assignment2.data.DisplayObject
import com.example.cse438.cse438_assignment2.data.Track

class GridFragment : Fragment() {

    lateinit var trackViewModel: TrackViewModel
    private lateinit var recyclerView: RecyclerView

    var trackList:ArrayList<Track> = ArrayList()
    var DisplayObjectList: ArrayList<DisplayObject> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_grid, container, false)
        recyclerView= rootView.findViewById(R.id.recyclerView) as RecyclerView


        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)


        var gridItemAdapter = GridItemAdapter(DisplayObjectList)
        recyclerView.adapter = gridItemAdapter
        recyclerView.layoutManager = GridLayoutManager(activity, 2)


        trackViewModel!!.trackList.observe(this, Observer {
            DisplayObjectList.clear()
            trackList.clear()
            trackList.addAll(it.data)
            for(track in trackList){
                DisplayObjectList.add(DisplayObject(track.album.cover_big, track.title, track.artist.name, "Track", null, track, null))
            }
            gridItemAdapter.notifyDataSetChanged()
        })
        trackViewModel.getChartTracks()

        return rootView
    }

}