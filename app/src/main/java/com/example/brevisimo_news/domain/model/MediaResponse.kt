package com.example.brevisimo_news.domain.model

import com.google.gson.annotations.SerializedName

data class MediaResponse(
    @SerializedName("status") val status: String,
    @SerializedName("sources") val sources: List<MediaDto>? = null
)
