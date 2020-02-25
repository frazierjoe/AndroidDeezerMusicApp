package com.example.cse438.cse438_assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.adapter.GridItemAdapter
import kotlinx.android.synthetic.main.fragment_grid.view.*


class GridFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_grid, container, false)

        recyclerView= rootView.findViewById(R.id.recyclerView) as RecyclerView

//        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = GridItemAdapter()
        return rootView
    }
}
