package com.example.brevisimo_news.domain.model

import com.google.gson.annotations.SerializedName

data class SourceDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String
)