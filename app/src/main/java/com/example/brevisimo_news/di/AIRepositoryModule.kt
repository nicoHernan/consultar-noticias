package com.example.brevisimo_news.di

import com.example.brevisimo_news.data.repository.AIResporitory
import com.example.brevisimo_news.data.repository.AIResporitoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AIRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindAIRepository(
        aiResporitoryImpl: AIResporitoryImpl
    ): AIResporitory
}