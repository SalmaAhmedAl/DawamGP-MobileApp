package com.example.dawam.ui.home.recycler_view
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dawam.api.model.waqfResponse.WaqfResponse
import com.example.dawam.databinding.ItemWaqfHomeBinding
class WaqfAdapter(val items: ArrayList<WaqfResponse>?):RecyclerView.Adapter<WaqfAdapter.ViewHolder>(){
    class ViewHolder (val viewBinding:ItemWaqfHomeBinding):RecyclerView.ViewHolder(viewBinding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemWaqfHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(viewBinding)
    }
    var onWaqfClick: OnWaqfClick?=null
    interface OnWaqfClick{
        fun onWaqfBtnClick(id: Int )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =items?.get(position)
        holder.viewBinding.waqfName.text=item?.waqfName
        holder.viewBinding.founderName.text=item?.founderName
        holder.viewBinding.waqfType.text=item?.waqfActivity
      //  holder.viewBinding.image.setIm(item?.imageUrl)
        holder.viewBinding.moreDetailsBtn.setOnClickListener {onWaqfClick?.onWaqfBtnClick(item!!.id)}
        //animation
        holder.itemView.translationY = holder.itemView.height.toFloat()
        holder.itemView.alpha = 0f
        holder.itemView.animate().translationY(0f).alpha(1f).setDuration(500L).start()
    }
    override fun getItemCount(): Int =items!!.size
}
