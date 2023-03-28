package com.example.dawam.ui.home.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dawam.databinding.ItemWaqfHomeBinding

class WaqfAdapter (val items:List<Waqf>):RecyclerView.Adapter<WaqfAdapter.ViewHolder>(){
    class ViewHolder (val viewBinding:ItemWaqfHomeBinding):RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemWaqfHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    var onWaqfClick: OnWaqfClick?=null
    interface OnWaqfClick{
        fun onWaqfBtnClick(name: String , image:Int)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =items.get(position)
        holder.viewBinding.waqfName.text=item.waqfName
        holder.viewBinding.waqfDateM.text=item.dateM
        holder.viewBinding.waqfDateHj.text=item.dateHj
        holder.viewBinding.image.setImageResource(item.imageId)
        holder.viewBinding.moreDetailsBtn.setOnClickListener {onWaqfClick?.onWaqfBtnClick(item.waqfName, item.imageId)}
    }

    override fun getItemCount(): Int =items.size
}

