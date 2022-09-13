package com.example.moviestest7.screens.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestest7.MAIN
import com.example.moviestest7.R
import com.example.moviestest7.databinding.FragmentMainBinding
import com.example.moviestest7.models.MoviesItemModel


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        viewModel.getAllMovies()
        viewModel.initDataBase()
        recyclerView = binding.rcMain
        recyclerView.adapter = adapter
        viewModel.myMovies.observe(this, {list ->
            adapter.setList(list.body()!!.results)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_favorite -> MAIN.navController.navigate(R.id.action_mainFragment_to_favoriteFragment)
        }
        return super.onOptionsItemSelected(item)
    }

    companion object{
        fun clickMovie(model: MoviesItemModel){
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }


}