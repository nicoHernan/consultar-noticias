package com.example.brevisimo_news.di

import android.content.Context
import com.example.brevisimo_news.data.local.LayoutPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatStoreModule {

    @Provides
    @Singleton
    fun provideLayoutPreferences(
        @ApplicationContext context: Context
    ): LayoutPreferences{
        return LayoutPreferences(context)
    }
}