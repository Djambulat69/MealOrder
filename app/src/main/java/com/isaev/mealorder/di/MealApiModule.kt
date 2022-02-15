package com.isaev.mealorder.di

import com.isaev.mealorder.domain.MealApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
class MealApiModule {

    @Provides
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @Singleton
    @ExperimentalSerializationApi
    @Provides
    fun provideMealApi(json: Json): MealApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(MediaType.parse("application/json")!!))
            .build()
            .create()
    }

    private companion object {
        private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }

}
