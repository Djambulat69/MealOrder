package com.isaev.mealorder.domain

import com.isaev.mealorder.CategoriesResponse
import com.isaev.mealorder.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET("filter.php")
    suspend fun mealsByCategory(
        @Query("c") category: String
    ): MealsResponse

    @GET("categories.php")
    suspend fun categories(): CategoriesResponse

}
