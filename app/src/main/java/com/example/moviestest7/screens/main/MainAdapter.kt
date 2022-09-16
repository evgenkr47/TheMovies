package com.example.moviestest7.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestest7.MAIN
import com.example.moviestest7.R
import com.example.moviestest7.models.MoviesItemModel
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var listMovies = emptyList<MoviesItemModel>()
    class MainViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.item_title.text = listMovies[position].title
        holder.itemView.item_date.text = listMovies[position].release_date

        Glide.with(MAIN)
            .load("https://image.tmdb.org/t/p/w300_and_h450_bestv2${listMovies[position].poster_path}")
            .placeholder(R.drawable.movieplaceholder)
            .into(holder.itemView.item_img)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setList(list: List<MoviesItemModel>){
        listMovies = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.clickMovie(listMovies[holder.adapterPosition])
        }
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}