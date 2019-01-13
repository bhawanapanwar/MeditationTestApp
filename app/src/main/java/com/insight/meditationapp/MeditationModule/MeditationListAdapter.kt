package com.insight.meditationapp.MeditationModule

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.insight.meditationapp.DescriptionModule.DescriptionActivity
import com.insight.meditationapp.R
import kotlinx.android.synthetic.main.adapter_meditation_list.view.*

class ListAdapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    var items = mutableListOf<ListModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_meditation_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context).load(items.get(position).image)
                .transition(withCrossFade())
                .into(holder.ivImage)

        holder.txTitle.text=items.get(position).title

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java)
           context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    fun setList(list: List<ListModel>) {
        items = list.toMutableList()
        this.notifyDataSetChanged()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivImage = view.imgView
    val txTitle = view.txTitle
}

