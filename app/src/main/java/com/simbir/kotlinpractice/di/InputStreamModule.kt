package com.simbir.kotlinpractice.di

import android.content.Context
import dagger.Module
import dagger.Provides
import java.io.InputStream

@Module
class InputStreamModule(private val context: Context, private val fileName: String) {

    @Provides
    fun provideInputStream():InputStream{
        return context.assets.open(fileName)
    }
}