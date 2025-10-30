package com.example.brevisimo_news.domain.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName ("status") val status: String,
    @SerializedName ("totalResults") val totalResults: Int? = null,
    @SerializedName ("articles") val articles: List<ArticleDto>? = null
)
