package com.isaev.mealorder.domain

import com.isaev.mealorder.Category
import com.isaev.mealorder.Meal
import javax.inject.Inject

class MealRemoteSource @Inject constructor(
    private val mealApi: MealApi
) {

    suspend fun mealsByCategory(category: String): List<Meal> =
        mealApi.mealsByCategory(category).meals

    suspend fun categories(): List<Category> =
        mealApi.categories().categories
}
