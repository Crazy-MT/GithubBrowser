/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mt.githubbrowser.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import com.mt.githubbrowser.BR

/**
 * Using name/owner_login as primary key instead of id since name/owner_login is always available
 * vs id is not.
 */
class Repo(i: Int, s: String, s1: String, s2: String, nothing: Nothing?, i1: Int) : BaseObservable(){
    var id: Int? = 0

    @field:SerializedName("name")
    var name: String? = null
        @Bindable
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @field:SerializedName("full_name")
    var fullName: String? = null
    @field:SerializedName("description")
    var description: String? = null
    @field:SerializedName("owner")
    @field:Embedded(prefix = "owner_")
    var owner: Owner? = null
    @field:SerializedName("stargazers_count")
    var stars: Int = 0

    init {
        name = s1
        description = s2
        stars = i1
    }

    data class Owner(
        @field:SerializedName("login")
        val login: String,
        @field:SerializedName("url")
        val url: String?
    )

    companion object {
        const val UNKNOWN_ID = -1
    }
}
