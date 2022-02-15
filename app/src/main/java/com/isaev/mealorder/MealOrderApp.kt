package com.isaev.mealorder

import android.app.Application
import com.isaev.mealorder.di.AppComponent
import com.isaev.mealorder.di.DaggerAppComponent

class MealOrderApp : Application() {

    val daggerAppComponent: AppComponent = DaggerAppComponent.create()


}
