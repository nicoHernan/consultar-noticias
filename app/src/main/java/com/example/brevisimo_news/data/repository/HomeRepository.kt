package com.example.brevisimo_news.data.repository

import com.example.brevisimo_news.domain.model.ArticleDto
import com.example.brevisimo_news.domain.model.MediaDto

interface HomeRepository {

    suspend fun getMediaInUs(country: String): List<ArticleDto>

    fun getListOfCategories(): List<String>
    suspend fun getCategoryContent(category: String): List<MediaDto>
    suspend fun getDomain(domains: String): List<ArticleDto>

    fun getLocalMediaSources(): List<MediaDto>
}