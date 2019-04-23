package br.com.pexed.lista_filmes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movie(val title: String,
            val overview: String,
            val duration: String,
            @SerializedName("release_year") val releaseYear: String,
            @SerializedName("cover_url") val coverUrl: String,
            @SerializedName("backdrops_url") val backdropsUrl: List<String>,
            val id: String): Serializable