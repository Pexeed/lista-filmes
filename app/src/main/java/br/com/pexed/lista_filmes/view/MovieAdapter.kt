package br.com.pexed.lista_filmes.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import br.com.pexed.lista_filmes.R
import br.com.pexed.lista_filmes._util.inflate
import br.com.pexed.lista_filmes.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*
import org.jetbrains.anko.intentFor

class MovieAdapter(val list: List<Movie>):
        RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder{
        val inflatedView = parent.inflate(R.layout.movie_item, false)
        val height = parent.measuredHeight / 2
        val width = parent.measuredWidth / 2
        inflatedView.setMinimumHeight(height)
        inflatedView.setMinimumWidth(width)

        return MovieHolder(inflatedView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val itemMovie = list.get(position)
        holder.bindMovie(itemMovie)
    }

    class MovieHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var movie: Movie? = null

        init { v.setOnClickListener(this) }

        fun bindMovie(movie: Movie) {
            this.movie = movie
            Picasso.get()
                    .load(movie.coverUrl)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(view.itemImage)

            view.itemTitle.text = movie.title
        }

        override fun onClick(v: View) {
            val c = itemView.context
            c.startActivity(c.intentFor<MovieInfoActivity>(KEY to movie))
        }

        companion object { private val KEY = "MOVIE" }
    }
}