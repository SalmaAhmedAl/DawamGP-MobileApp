package com.example.dawam.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.dawam.databinding.ItemWaqfBinding

class WaqfAdapter (val items:List<Waqf>):RecyclerView.Adapter<WaqfAdapter.ViewHolder>(){
    class ViewHolder (val viewBinding:ItemWaqfBinding):RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemWaqfBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    var onWaqfClick:OnWaqfClick ?=null
    interface OnWaqfClick{
        fun onWaqfBtnClick(name: String , position:Int, image:Int)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =items.get(position)
        holder.viewBinding.waqfName.text=item.name
        holder.viewBinding.waqfDateM.text=item.dateM
        holder.viewBinding.waqfDateHj.text=item.dateHj
        holder.viewBinding.image.setImageResource(item.imageId)
        holder.viewBinding.moreDetailsBtn.setOnClickListener {onWaqfClick?.onWaqfBtnClick(item.name,position, item.imageId)}
    }

    override fun getItemCount(): Int =items.size
}

