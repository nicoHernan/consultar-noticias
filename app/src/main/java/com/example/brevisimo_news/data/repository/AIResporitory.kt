package com.example.brevisimo_news.data.repository

interface AIResporitory {
    suspend fun extractKeyEntities(text: String): List<String>
}