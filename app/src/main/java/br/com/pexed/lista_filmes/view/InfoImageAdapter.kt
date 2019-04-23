package br.com.pexed.lista_filmes.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import br.com.pexed.lista_filmes.R
import br.com.pexed.lista_filmes._util.inflate
import br.com.pexed.lista_filmes.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.info_image_item.view.*

class InfoImageAdapter(val movie: Movie):
        RecyclerView.Adapter<InfoImageAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder{
        val inflatedView = parent.inflate(R.layout.info_image_item, false)
        return ImageHolder(inflatedView)
    }

    override fun getItemCount(): Int = movie.backdropsUrl.size + 1

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        if(position == 0){
            holder.bindImage(movie.coverUrl)
        }else{
            holder.bindImage(movie.backdropsUrl[position-1])
        }
    }

    class ImageHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v

        fun bindImage(image: String) {
            Picasso.get()
                    .load(image)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(view.itemInfoImage)
        }
    }
}