package com.isaev.mealorder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isaev.mealorder.domain.MealsRepository
import kotlinx.coroutines.launch

class MenuViewModel(
    private val mealsRepository: MealsRepository
) : ViewModel() {

    private val _meals = MutableLiveData<List<Meal>>()

    val meals: LiveData<List<Meal>> = _meals


    fun loadMeals() {
        viewModelScope.launch {
            val newMeals = mealsRepository.getMealsByCategory("Chicken")
            _meals.value = newMeals
        }
    }

}
