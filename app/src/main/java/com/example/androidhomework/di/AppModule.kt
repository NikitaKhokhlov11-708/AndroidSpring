package com.example.androidhomework.di

import android.content.Context
import com.example.androidhomework.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApp(): Context = app
}