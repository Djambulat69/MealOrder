package com.isaev.mealorder

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MealsResponse(
    @SerialName("meals")
    val meals: List<Meal>
)

@Serializable
data class Meal(
    @SerialName("strMeal")
    val strMeal: String,
    @SerialName("strMealThumb")
    val strMealThumb: String,
    @SerialName("idMeal")
    val idMeal: String
)
