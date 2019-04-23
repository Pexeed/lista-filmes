package br.com.pexed.lista_filmes.model.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactory {

    companion object {
        private const val MOVIES_API = "https://sky-exercise.herokuapp.com/api/"
        private val retrofit = Retrofit.Builder()
                .baseUrl(MOVIES_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val movieService: MovieService
            get() {
                return retrofit.create<MovieService>(MovieService::class.java)
            }
    }
}