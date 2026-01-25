package com.example.brevisimo_news.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookmarksDto(
    @SerialName("bookmarks_id") val bookmarksId: String? = null,
    @SerialName("user_id") val userId: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description:String? = null,
    @SerialName("url") val url: String,
    @SerialName("image_url") val imageUrl: String? = null,
    @SerialName("source_name") val sourceName: String? = null,
    @SerialName("created_at") val createdAt: String? = null
)
