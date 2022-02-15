package com.isaev.mealorder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MealsAdapter : RecyclerView.Adapter<MealViewHolder>() {

    private class MealItemDiffCallback : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, MealItemDiffCallback())

    var items: List<Meal>
        get() = differ.currentList
        set(newItems) {
            differ.submitList(newItems)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_item, parent, false)

        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
