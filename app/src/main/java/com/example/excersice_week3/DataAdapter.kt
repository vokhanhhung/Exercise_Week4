package com.example.excersice_week3

import Data
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DataAdapter(val datas: List<Data>, val context: Context) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var name: TextView
        var popularity: TextView
        var vote_count: TextView
        var vote_average: TextView

        init {
            itemView.layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
            img = itemView.findViewById<ImageView>(R.id.imageView)
            name = itemView.findViewById(R.id.tvName)
            popularity = itemView.findViewById(R.id.tvPopulatity)
            vote_count = itemView.findViewById(R.id.tvVoteCount)
            vote_average = itemView.findViewById(R.id.tvVoteAvegare)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(context).inflate(R.layout.item, null, false))
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        var data = datas.get(position)
        var url = "https://image.tmdb.org/t/p/w500/" + data.poster_path
        Glide.with(context).load(url).into(holder.img)
        holder.name.text = data.title
        holder.popularity.text = "Popularity: " + data.popularity.toString()
        holder.vote_count.text = "Vote count: " + data.vote_count.toString()
        holder.vote_average.text = "Vote average:" + data.vote_average.toString()


    }
}