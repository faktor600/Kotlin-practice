package com.simbir.kotlinpractice.di.component

import com.simbir.kotlinpractice.di.*
import com.simbir.kotlinpractice.domain.iteractors.GetCategoriesCase
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ApiModule::class,
        AppContextModule::class,
        AppDatabaseModule::class,
        GsonModule::class,
        InputStreamModule::class
    ]
)
@AppDatabaseScope
@Singleton
interface GetCategoriesComponent {

    fun getCategoriesCase(): GetCategoriesCase
}