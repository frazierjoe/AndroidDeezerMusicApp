package com.example.cse438.cse438_assignment2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.data.DisplayObject
import kotlinx.android.synthetic.main.grid_item.view.*
import java.util.*


class GridViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.grid_item, parent, false)){
    private val mainText: TextView
    private val subText: TextView
    init {
        mainText = itemView.findViewById(R.id.gridTextMain)
        subText = itemView.findViewById(R.id.gridTextSub)
    }

    fun bind(displyObject: DisplayObject){
        mainText.text = displyObject.mainText
        subText.text = displyObject.subText
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

