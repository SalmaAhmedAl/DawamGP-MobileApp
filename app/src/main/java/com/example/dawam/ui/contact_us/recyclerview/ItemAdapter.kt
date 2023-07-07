package com.example.dawam.ui.contact_us.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.dawam.databinding.ItemContactUsBinding

class ItemAdapter(val items :List<itemDM>):RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder (val viewBinding: ItemContactUsBinding):RecyclerView.ViewHolder(viewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemContactUsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =items.get(position)
        holder.viewBinding.text.text=item.contactText
        holder.viewBinding.icon.setImageResource(item.imageId)
        //simple animation
//        holder.viewBinding.root.apply {
//            alpha = 0f
//            translationY = 50f
//            animate()
//                .alpha(1f)
//                .translationY(0f)
//                .setDuration(500) // بالميلي ثانية
//                .setInterpolator(OvershootInterpolator())
//                .start()
//        }
        holder.viewBinding.icon.apply {
            alpha = 0f
            translationY = 50f
            animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(500) // بالميلي ثانية
                .setInterpolator(OvershootInterpolator())
                .start()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}