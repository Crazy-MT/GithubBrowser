package com.mt.githubbrowser.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.mt.githubbrowser.BR

 class RepoSearchResponse : BaseObservable() {
    var nextPage: Int? = null
    @SerializedName("total_count")
    var total: Int = 0
    @SerializedName("items")
    var items: List<Repo>? = null
        @Bindable
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.items)
        }
}
