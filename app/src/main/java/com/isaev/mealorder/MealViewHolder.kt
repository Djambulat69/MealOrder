package com.isaev.mealorder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isaev.mealorder.databinding.MealItemBinding

class MealViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: MealItemBinding = MealItemBinding.bind(view)

    fun bind(meal: Meal) {
        with(binding) {
            Glide.with(itemView.context)
                .load(meal.strMealThumb)
                .into(mealImage)

            mealName.text = meal.strMeal
        }
    }

}
