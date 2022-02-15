package com.isaev.mealorder.domain

import com.isaev.mealorder.Category
import com.isaev.mealorder.Meal
import javax.inject.Inject

class MealsRepository @Inject constructor(
    private val mealRemoteSource: MealRemoteSource
) {

    suspend fun getMealsByCategory(category: String): List<Meal> =
        mealRemoteSource.mealsByCategory(category)

    suspend fun getCategories(): List<Category> =
        mealRemoteSource.categories()

}
