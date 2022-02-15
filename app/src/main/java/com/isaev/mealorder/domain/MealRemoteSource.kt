package com.isaev.mealorder.domain

import com.isaev.mealorder.Meal

class MealRemoteSource(
    private val mealApi: MealApi
) {

    suspend fun mealsByCategory(category: String): List<Meal> =
        mealApi.mealsByCategory(category).meals

}
