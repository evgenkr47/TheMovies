package com.example.moviestest7.screens.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestest7.MAIN
import com.example.moviestest7.R
import com.example.moviestest7.models.MoviesItemModel
import com.example.moviestest7.screens.main.MainAdapter
import kotlinx.android.synthetic.main.item_layout.view.*

class FavoriteAdapter:RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    private var listMovies = emptyList<MoviesItemModel>()
    class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.itemView.item_title.text = listMovies[position].title
        holder.itemView.item_date.text = listMovies[position].release_date

        Glide.with(MAIN)
            .load("https://image.tmdb.org/t/p/w300_and_h450_bestv2${listMovies[position].poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.item_img)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setList(list: List<MoviesItemModel>){
        listMovies = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: FavoriteViewHolder) {
        holder.itemView.setOnClickListener {
            FavoriteFragment.clickMovie(listMovies[holder.adapterPosition])
        }
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: FavoriteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}