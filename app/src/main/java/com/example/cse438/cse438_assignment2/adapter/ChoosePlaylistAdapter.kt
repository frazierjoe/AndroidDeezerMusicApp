package com.example.cse438.cse438_assignment2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.activities.MainActivity
import com.example.cse438.cse438_assignment2.db.Playlist

//create the view holder
class ChoosePlaylistViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.playlist_list_row, parent, false)) {
    private val plTitle: TextView?
    private val plDescription: TextView?
    private val plContainer: LinearLayout

    //creates and displays each playlist
    init {
        plTitle = itemView.findViewById(R.id.playlistTitle)
        plDescription = itemView.findViewById(R.id.playlistDescription)
        plContainer = itemView.findViewById(R.id.playlistContainer)
    }

    fun bind(pl: Playlist, tID: String) {
        plTitle?.text = pl.title
        plDescription?.text = pl.description

        plContainer.setOnClickListener {
            var plTit = pl.title
            var plID = pl.id.toString()
            val context =it.context
            val intent = Intent(context, MainActivity::class.java).apply {
                putExtra("playlist id", plID)
                putExtra("playlist title", plTit)
                putExtra("track id", tID)
            }
            context.startActivity(intent)
        }
    }
}

//create the listener for the recycler view
class ChoosePlaylistAdapter(private val list: ArrayList<Playlist>?, private val tID: String) : RecyclerView.Adapter<ChoosePlaylistViewHolder>() {
    private var listEvents: ArrayList<Playlist>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoosePlaylistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ChoosePlaylistViewHolder(inflater, parent)
    }

    //bind the object
    override fun onBindViewHolder(holder: ChoosePlaylistViewHolder, position: Int) {
        val event: Playlist = listEvents!!.get(position)
        holder.bind(event, tID)
    }

    //set the count
    override fun getItemCount(): Int = list!!.size

}

