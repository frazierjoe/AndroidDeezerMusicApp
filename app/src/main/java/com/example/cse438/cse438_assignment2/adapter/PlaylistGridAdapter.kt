package com.example.cse438.cse438_assignment2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.activities.ArtistActivity
import com.example.cse438.cse438_assignment2.activities.PlaylistTrackActivity
import com.example.cse438.cse438_assignment2.data.DisplayObject
import com.squareup.picasso.Picasso
import java.util.*


class PlaylistGridViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.grid_item, parent, false)){
    private val mainText: TextView
    private val subText: TextView
    private val imageView: ImageView
    private val gridContainer: LinearLayout

    //grid view of tracks in this playlist
    init {
        mainText = itemView.findViewById(R.id.gridTextMain)
        subText = itemView.findViewById(R.id.gridTextSub)
        imageView = itemView.findViewById(R.id.imageView)
        gridContainer = itemView.findViewById(R.id.gridItemContainer)
    }

    fun bind(displayObject: DisplayObject){
        var image = displayObject.image
        Picasso.with(imageView.context).load(image).into(imageView)
        mainText.text = displayObject.mainText
        subText.text = displayObject.subText


        gridContainer.setOnClickListener {
            if(displayObject.objectType == "Track"){
                var id = displayObject.id
                var s = displayObject.song
                val context =it.context
                val intent = Intent(context, PlaylistTrackActivity::class.java).apply {
                    putExtra("id",id)
                    putExtra("song id", s?.songID)
                    putExtra("playlist id", s?.playlistID)
                    putExtra("track id", s?.trackID)
                }
                context.startActivity(intent)
            }
            else if(displayObject.objectType == "Artist"){
                var id = displayObject.id
                val context = it.context
                val intent = Intent(context, ArtistActivity::class.java).apply { //TODO 1
                    putExtra("id",id)
                }
                context.startActivity(intent)
            }
        }
    }
}

class PlaylistGridItemAdapter (private val list: ArrayList<DisplayObject>):RecyclerView.Adapter<PlaylistGridViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistGridViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlaylistGridViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PlaylistGridViewHolder, position: Int) {
        val displyObject: DisplayObject = list[position]
        holder.bind(displyObject)
    }

    override fun getItemCount(): Int = list.size
}

