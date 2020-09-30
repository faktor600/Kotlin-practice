package com.simbir.kotlinpractice.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppContextModule (private val context: Context){

    @Provides
    fun provideContext(): Context{
        return context
    }
}