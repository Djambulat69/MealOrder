package com.isaev.mealorder.domain

import com.isaev.mealorder.Meal

class MealsRepository(
    private val mealRemoteSource: MealRemoteSource
) {

    suspend fun getMealsByCategory(category: String): List<Meal> =
        mealRemoteSource.mealsByCategory(category)

}
