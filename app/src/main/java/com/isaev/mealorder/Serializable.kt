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

@Serializable
data class CategoriesResponse(
    @SerialName("categories")
    val categories: List<Category>
)

@Serializable
data class Category(
    @SerialName("idCategory")
    val idCategory: String,
    @SerialName("strCategory")
    val strCategory: String,
    @SerialName("strCategoryThumb")
    val strCategoryThumb: String,
    @SerialName("strCategoryDescription")
    val strCategoryDescription: String
)
