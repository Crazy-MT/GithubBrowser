package com.mt.githubbrowser.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mt.githubbrowser.model.Repo
import com.mt.githubbrowser.model.RepoSearchResponse
import com.mt.githubbrowser.repository.SearchSource
import kotlinx.coroutines.launch

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/16 16:06
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
class RepoViewModel : ViewModel() {
    val source = SearchSource()
    var repoSearchResp : MutableLiveData<List<Repo>> = MutableLiveData<List<Repo>>()

    fun search(query: String) {
        viewModelScope.launch {
            runCatching {
                repoSearchResp.postValue(source.searchRepo(query).items)
//                Log.e(TAG, ": MTMTMT " + Thread.currentThread().name);
            }.onSuccess {
//                Log.e(TAG, ": MTMTMT " + "success" + Thread.currentThread().name);
            }.onFailure {
//                repoSearchResp.postValue(RepoSearchResponse(1, 1, arrayListOf(Repo(1, "1", "22", "true", null, 1))))
                Log.e(TAG, ": MTMTMT " + it.message + Thread.currentThread().name);
//                repoSearchResp.value = arrayListOf(Repo(1, "12", "22", "true", null, 1))
            }
        }
    }

    companion object {
        private const val TAG = "RepoViewModel"
    }

}