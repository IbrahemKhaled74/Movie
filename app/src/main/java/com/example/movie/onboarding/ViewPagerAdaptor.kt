package com.example.movie.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.movie.R
import com.example.movie.databinding.ViewPagerItemBinding

class ViewPagerAdaptor(private val item:List<ViewPagerItem>?):RecyclerView.Adapter<ViewPagerAdaptor.ViewPagerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view:ViewPagerItemBinding=
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.view_pager_item,
                parent,
                false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val itemPosition= item?.get(position)
        if (itemPosition != null) {
            holder.bind(itemPosition)
        }
    }

    override fun getItemCount(): Int = item?.size?:0

    inner class ViewPagerViewHolder(private val viewPagerItem:ViewPagerItemBinding?):ViewHolder(viewPagerItem?.root!!){
    fun bind( item: ViewPagerItem){
        viewPagerItem?.items=item
        viewPagerItem?.executePendingBindings()
    }
}
}