package com.example.moviestest7.screens.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestest7.MAIN
import com.example.moviestest7.R
import com.example.moviestest7.databinding.FragmentFavoriteBinding
import com.example.moviestest7.models.MoviesItemModel
import com.example.moviestest7.screens.main.MainAdapter
import com.example.moviestest7.screens.main.MainFragmentViewModel


class FavoriteFragment : Fragment() {
    lateinit var binding: FragmentFavoriteBinding
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { FavoriteAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        val viewModel = ViewModelProvider(this).get(FavoriteFragmentViewModel::class.java)
        viewModel.getAllMovies().observe(this, {list ->
            adapter.setList(list.asReversed())
        })
        recyclerView = binding.rcFavorite
        recyclerView.adapter = adapter
    }

    companion object{
        fun clickMovie(model: MoviesItemModel){
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
        }
    }


}