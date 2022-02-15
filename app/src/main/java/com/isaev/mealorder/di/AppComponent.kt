package com.isaev.mealorder.di

import com.isaev.mealorder.MenuFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MealApiModule::class])
interface AppComponent {
    fun inject(menuFragment: MenuFragment)
}
