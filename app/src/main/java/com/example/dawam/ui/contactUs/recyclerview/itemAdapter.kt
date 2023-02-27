package com.example.dawam.ui.contactUs.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dawam.databinding.ItemDesignBinding

class ItemAdapter(val items :MutableList<itemDM>):RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder (val viewBinding: ItemDesignBinding):RecyclerView.ViewHolder(viewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =items.get(position)
        holder.viewBinding.text.text=item.contactText
        holder.viewBinding.icon.setImageResource(item.imageId)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}