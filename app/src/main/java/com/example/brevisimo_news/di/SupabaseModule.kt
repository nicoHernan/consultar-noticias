package com.example.brevisimo_news.di

import com.example.brevisimo_news.data.repository.SupabaseImpl
import com.example.brevisimo_news.data.repository.SupabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SupabaseModule {
    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://zvagfijdyfiddrzqabsl.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inp2YWdmaWpkeWZpZGRyenFhYnNsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjkxODk1OTksImV4cCI6MjA4NDc2NTU5OX0.I_pPfCc1esB5LiFYFzF6DwGaVq73UlbJvhKy3l90xQY"
        ) {
            install(Postgrest)
        }
    }
    @Provides
    @Singleton
    fun provideSupabaseRepository(supabaseClient: SupabaseClient): SupabaseRepository {
        return SupabaseImpl(supabaseClient)
    }
}