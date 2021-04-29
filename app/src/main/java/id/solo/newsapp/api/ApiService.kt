package id.solo.newsapp.api

import id.solo.newsapp.model.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("exec")
    fun getNews (@Query("id") id :String,
                 @Query("sheet") sheet : String
    ) : Call<ResponseNews>
}