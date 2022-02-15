package com.isaev.mealorder

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.isaev.mealorder.databinding.FragmentMenuBinding

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val viewModel by viewModels<MenuViewModel>()

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentMenuBinding.bind(view)

        binding.mealsRecycler.adapter = MealsAdapter()

        viewModel.meals.observe(viewLifecycleOwner) { meals ->
            (binding.mealsRecycler.adapter as MealsAdapter).items = meals
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
