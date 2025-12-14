package com.example.brevisimo_news.di

import com.google.firebase.Firebase
import com.google.firebase.ai.GenerativeModel
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenerativeAIProviderModule {

    @Provides
    @Singleton
    fun provideIAModel(): GenerativeModel{
        val firebaseAiClient = Firebase.ai(backend = GenerativeBackend.googleAI())
        return firebaseAiClient.generativeModel(modelName = "gemini-2.5-flash")
    }
}