package com.mt.githubbrowser.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mt.githubbrowser.model.RepoSearchResponse
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.math.log

/**
 *  @author : MaoTong
 *  @date : 2020/9/16 17:43
 *  description :
 */

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/16 17:43
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
interface Api {

    @GET("search/repositories")
    suspend fun searchRepos(@Query("q") query: String): RepoSearchResponse

    companion object {
        private const val BASE_URL = "https://api.github.com/"
        fun create() : Api {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL.toHttpUrlOrNull())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }
}