package id.solo.newsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        headline_news_detail.text = intent.getStringExtra("JUDUL")

        val foto = intent.getStringExtra("FOTO")
        Glide.with(this)
            .load(foto)
            .into(foto_news_detail)

        detail_news.webChromeClient = WebChromeClient()
        detail_news.settings.javaScriptEnabled = true
        detail_news.loadData(
            intent.getStringExtra("DETAIL")!!,
            "text/html", "UTF-8")
    }
}