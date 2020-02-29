package com.example.cse438.cse438_assignment2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.db.Playlist

//create the view holder
class PlaylistViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.playlist_list_row, parent, false)) {
    private val plTitle: TextView?
    private val plDescription: TextView?

    init {
        plTitle = itemView.findViewById(R.id.playlistTitle)
        plDescription = itemView.findViewById(R.id.playlistDescription)
    }

    fun bind(pl: Playlist) {
        plTitle?.text = pl.title
        plDescription?.text = pl.description

    }
}

//create the listener for the recycler view
class PlaylistListAdapter(private val list: ArrayList<Playlist>?) : RecyclerView.Adapter<PlaylistViewHolder>() {
    private var listEvents: ArrayList<Playlist>? = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlaylistViewHolder(inflater, parent)
    }

    //bind the object
    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val event: Playlist = listEvents!!.get(position)
        holder.bind(event)
    }

    //set the count
    override fun getItemCount(): Int = list!!.size

}