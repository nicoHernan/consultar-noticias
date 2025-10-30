package com.example.brevisimo_news.di

import com.example.brevisimo_news.data.local.MediaDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 class MediaModule {

    @Provides
    @Singleton
    fun provideMediaDataSource(): MediaDataSource {
        return MediaDataSource()
    }
}