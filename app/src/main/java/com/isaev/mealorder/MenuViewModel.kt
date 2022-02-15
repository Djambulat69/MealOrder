package com.isaev.mealorder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isaev.mealorder.domain.MealsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val mealsRepository: MealsRepository
) : ViewModel() {

    private val _meals = MutableLiveData<List<Meal>>()
    private val _categories = MutableLiveData<List<Category>>()

    val meals: LiveData<List<Meal>> = _meals
    val categories: LiveData<List<Category>> = _categories


    init {
        loadCategories()
    }

    fun loadMeals(category: String) {
        viewModelScope.launch {
            val newMeals = mealsRepository.getMealsByCategory(category)
            _meals.value = newMeals
        }
    }

    fun loadCategories() {
        viewModelScope.launch {
            val newCategories = mealsRepository.getCategories()
            _categories.value = newCategories
        }
    }

}
