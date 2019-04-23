package br.com.pexed.lista_filmes.view

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Layout
import br.com.pexed.lista_filmes.R
import br.com.pexed.lista_filmes.model.Movie
import kotlinx.android.synthetic.main.activity_movie_info.*

class MovieInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_info)

        val movie: Movie = intent.getSerializableExtra("MOVIE") as Movie

        tvInfoTitle.text = movie.title
        tvInfoReleaseYear.text = movie.releaseYear
        tvInfoDuration.text = movie.duration
        tvInfoOverview.text = movie.overview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tvInfoOverview.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
        }

        rvInfoImages.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvInfoImages.adapter = InfoImageAdapter(movie)
    }
}
