package com.example.dawam.ui.waqf_details.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.dawam.databinding.ItemWaqfDetailsBinding

class WaqfDetailsAdapter (val items :List<LineItem>):RecyclerView.Adapter<WaqfDetailsAdapter.ViewHolder>(){

    class ViewHolder (val viewBinding:ItemWaqfDetailsBinding):RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =ItemWaqfDetailsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        with(holder.viewBinding) {
            label.text= item.label
            input.text= item.input
        }
    }

    override fun getItemCount(): Int =items.size
}