package com.example.brevisimo_news.data.repository

interface AIRepository {
    suspend fun extractKeyEntities(text: String): List<String>
}