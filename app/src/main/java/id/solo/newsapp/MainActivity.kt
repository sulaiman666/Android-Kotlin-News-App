package id.solo.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import id.solo.newsapp.Adapter.AdapterNews
import id.solo.newsapp.api.ApiRetrofit
import id.solo.newsapp.model.DataItem
import id.solo.newsapp.model.ResponseNews
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_news.layoutManager = GridLayoutManager(this, 1)

        getData()
    }

    private fun getData() {
        ApiRetrofit.create().getNews("1pbg0fV8rYGKc2tYSL04un80zvTg7vvYLlB4yk-PjQkQ",
        "1")
                .enqueue(object : Callback<ResponseNews> {
                    override fun onResponse(call: Call<ResponseNews>?, response: Response<ResponseNews>?) {
                        Log.e("FETCH", "Data fetch! ${Gson().toJson(response?.body()?.data as ArrayList<DataItem>)}")

                        val adapter = AdapterNews(response?.body()?.data as ArrayList<DataItem>  )
                        recycler_news.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }

                    override fun onFailure(call: Call<ResponseNews>?, t: Throwable?) {
                        // In case result error/Fetch error
                        Toast.makeText(this@MainActivity, "Result error!", Toast.LENGTH_LONG).show()
                    }
                })
    }
}