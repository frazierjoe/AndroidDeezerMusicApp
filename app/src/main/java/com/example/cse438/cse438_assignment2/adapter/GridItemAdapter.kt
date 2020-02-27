package com.example.cse438.cse438_assignment2.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.EXTRA_TRACK
import com.example.cse438.cse438_assignment2.MainActivity
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.TrackActivity
import com.example.cse438.cse438_assignment2.data.DisplayObject
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.grid_item.view.*
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
                //TODO Send Data to track activity
                val intent = Intent(context, TrackActivity::class.java).apply {
                    putExtra("id",id )
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

