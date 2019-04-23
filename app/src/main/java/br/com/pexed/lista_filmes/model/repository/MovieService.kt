package br.com.pexed.lista_filmes.model.repository

import br.com.pexed.lista_filmes.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("Movies")
    fun listMovies(): Call<List<Movie>>
}