package com.example.moviestest7.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.moviestest7.MAIN
import com.example.moviestest7.R
import com.example.moviestest7.SaveShared
import com.example.moviestest7.databinding.FragmentDetailBinding
import com.example.moviestest7.models.MoviesItemModel
import com.example.moviestest7.screens.main.MainFragmentViewModel


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var currentMovie: MoviesItemModel
    private var isFavorite = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentMovie = arguments?.getSerializable("movie") as MoviesItemModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        val viewModel = ViewModelProvider(this).get(DetailFragmentViewModel::class.java)
        val valueBool = SaveShared.getFavorite(MAIN, currentMovie.id.toString())
        binding.tvTitle.text = currentMovie.title
        binding.tvDate.text = currentMovie.release_date
        binding.tvDesc.text = currentMovie.overview

        if (isFavorite != valueBool){
            binding.imgFavoriteDetail.setImageResource(R.drawable.ic_hearth_full)
        }
        else{
            binding.imgFavoriteDetail.setImageResource(R.drawable.ic_hearth)
        }

        Glide.with(MAIN)
            .load("https://image.tmdb.org/t/p/w300_and_h450_bestv2${currentMovie.poster_path}")
            .placeholder(R.drawable.movieplaceholder)
            .into(binding.imgFavorite)

        binding.imgFavoriteDetail.setOnClickListener {
            if(isFavorite == valueBool){
                binding.imgFavoriteDetail.setImageResource(R.drawable.ic_hearth_full)
                SaveShared.setFavorite(MAIN, currentMovie.id.toString(), true)
                viewModel.insert(currentMovie){}
                isFavorite = true
            }
            else{
                binding.imgFavoriteDetail.setImageResource(R.drawable.ic_hearth)
                SaveShared.setFavorite(MAIN, currentMovie.id.toString(), false)
                viewModel.delete(currentMovie){}
                isFavorite = false
            }
        }
    }

}