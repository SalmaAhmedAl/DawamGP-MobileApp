package com.example.dawam.ui.contactUs.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dawam.R

class itemAdapter(val items :MutableList<itemDM>):RecyclerView.Adapter<itemAdapter.viewHolder>(){
    class viewHolder(itemViwe: View):RecyclerView.ViewHolder(itemViwe){
        val contactImage :ImageView=itemViwe.findViewById(R.id.icon)
        val contactText :ImageView=itemViwe.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent,false)

        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item= items[position]
        holder.contactImage.setImageResource(item.imageId)
       // holder.contactText.text = item.text
    }

    override fun getItemCount(): Int {
        return items.size
    }
}