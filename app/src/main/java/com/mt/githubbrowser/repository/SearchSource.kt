package com.mt.githubbrowser.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mt.githubbrowser.api.Api
import com.mt.githubbrowser.api.ApiResponse
import com.mt.githubbrowser.model.RepoSearchResponse
import retrofit2.HttpException
import java.io.IOException

/**
 *  @author : MaoTong
 *  @date : 2020/9/16 18:01
 *  description :
 */

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/16 18:01
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
class SearchSource{
    private val api= Api.create()

//    suspend fun searchRepo(query: String) : MutableLiveData<ApiResponse<RepoSearchResponse>> {
        suspend fun searchRepo(query: String) : RepoSearchResponse {
            return api.searchRepos(query)
    }
}