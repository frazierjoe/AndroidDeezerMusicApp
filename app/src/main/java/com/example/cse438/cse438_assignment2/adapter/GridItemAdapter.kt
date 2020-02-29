package com.example.cse438.cse438_assignment2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.activities.ArtistActivity
import com.example.cse438.cse438_assignment2.activities.TrackActivity
import com.example.cse438.cse438_assignment2.data.DisplayObject
import com.squareup.picasso.Picasso
import java.util.*


class GridViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.grid_item, parent, false)){
    private val mainText: TextView
    private val subText: TextView
    private val imageView: ImageView
    private val gridContainer: LinearLayout

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
                val context =it.context
                val intent = Intent(context, TrackActivity::class.java).apply {
                    putExtra("id",id )
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

class GridItemAdapter (private val list: ArrayList<DisplayObject>):RecyclerView.Adapter<GridViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GridViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val displyObject: DisplayObject = list[position]
        holder.bind(displyObject)
    }

    override fun getItemCount(): Int = list.size
}

