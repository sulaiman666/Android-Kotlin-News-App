package id.solo.newsapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.solo.newsapp.DetailActivity
import id.solo.newsapp.R
import id.solo.newsapp.model.DataItem
import kotlinx.android.synthetic.main.item_news.view.*

class AdapterNews(val listNews : ArrayList<DataItem>)
    : RecyclerView.Adapter<AdapterNews.MyHolder> () {

    inner class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNews.MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterNews.MyHolder, position: Int) {
        holder.itemView.headline_berita.text = listNews[position].nama_berita

        Glide.with(holder.itemView.context)
                .load(listNews[position].url_image)
                .into(holder.itemView.foto_news)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra("JUDUL", listNews[position].nama_berita)
            intent.putExtra("FOTO", listNews[position].url_image)
            intent.putExtra("DETAIL", listNews[position].isi_berita)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}