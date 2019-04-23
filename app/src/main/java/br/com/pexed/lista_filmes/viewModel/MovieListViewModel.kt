package br.com.pexed.lista_filmes.viewModel

import android.app.Application
import android.arch.lifecycle.*
import br.com.pexed.lista_filmes.model.Movie
import br.com.pexed.lista_filmes.model.repository.MovieRepository

class MovieListViewModel() : ViewModel(), LifecycleObserver {

    var movieList: LiveData<List<Movie>> = MutableLiveData()
    val movieRepository = MovieRepository()

    init {
        movieList = movieRepository.getMovieList()
    }

    fun getMovies(): LiveData<List<Movie>> {
        return movieList
    }

    private fun loadMovies() {
        movieList = movieRepository.getMovieList()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() { loadMovies() }

}