package br.com.pexed.lista_filmes.model.repository

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import br.com.pexed.lista_filmes.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MovieRepository {

    private val TAG = MovieRepository::class.java.simpleName

    fun getMovieList(): MutableLiveData<List<Movie>> {
        val data = MutableLiveData<List<Movie>>()

        ServiceFactory.movieService.listMovies().enqueue(object : Callback<List<Movie>?> {
            override fun onResponse(call: Call<List<Movie>?>?, response: Response<List<Movie>?>) {
                response.body()?.let {
                    data.value = it
                    Log.d(TAG, "Populated list")
                }
            }

            override fun onFailure(call: Call<List<Movie>?>?, t: Throwable) {
                data.value = ArrayList()
                Log.d(TAG, "Request error.")
            }
        })
        return data
    }
}