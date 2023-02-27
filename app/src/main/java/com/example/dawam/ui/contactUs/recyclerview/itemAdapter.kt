package com.example.dawam.ui.contactUs.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dawam.R
import com.example.dawam.databinding.ItemDesignBinding
import com.example.dawam.databinding.ItemWaqfBinding
import com.example.dawam.ui.home.WaqfAdapter

class itemAdapter(val items :MutableList<itemDM>):RecyclerView.Adapter<itemAdapter.viewHolder>(){
    class viewHolder (val viewBinding: ItemDesignBinding):RecyclerView.ViewHolder(viewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return itemAdapter.viewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item =items.get(position)
        holder.viewBinding.text.text=item.contactText
        holder.viewBinding.icon.setImageResource(item.imageId)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}