package com.example.cse438.cse438_assignment2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import kotlinx.android.synthetic.main.grid_item.view.*

class GridItemAdapter : RecyclerView.Adapter<CustomViewHolder>(){
    val mainTextList = listOf("First title", "Second", "3rd", "Moore Title")
    val subTextList = listOf("sub1", "sub2", "sub3", "sub4")

    //number of item
    override fun getItemCount(): Int {
        return mainTextList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //create view

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.grid_item, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val mainText = mainTextList[position]
        val subText = subTextList[position]
        holder?.view?.gridTextMain.text= mainText
        holder?.view?.gridTextSub.text= subText
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}

