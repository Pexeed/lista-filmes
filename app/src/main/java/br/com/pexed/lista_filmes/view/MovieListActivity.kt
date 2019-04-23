package br.com.pexed.lista_filmes.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import br.com.pexed.lista_filmes.R
import br.com.pexed.lista_filmes.viewModel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity() {

    val viewModel: MovieListViewModel by lazy {
        ViewModelProviders.of(this).get(MovieListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        lifecycle.addObserver(viewModel)

        pbLoadingList.visibility = View.VISIBLE
        rvMovieList.layoutManager = GridLayoutManager(this, 2)
        viewModel.getMovies().observe(this, Observer {
            it?.let {
                rvMovieList.adapter = MovieAdapter(it)
                pbLoadingList.visibility = View.GONE
            }
        })

    }
}
