package com.github.bagus.data

import com.andrian.githubuserapi.data.User
import com.google.gson.annotations.SerializedName

class UserList (
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<User>,
    @SerializedName("total_count")
    val totalCount: Int
)