package com.isaev.mealorder

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.isaev.mealorder.databinding.FragmentMenuBinding
import javax.inject.Inject
import javax.inject.Provider

class MenuFragment : Fragment(R.layout.fragment_menu) {

    @Inject
    lateinit var viewModelProvider: Provider<MenuViewModel>

    private val viewModel by viewModelsFactory<MenuViewModel> { viewModelProvider.get() }

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireContext().applicationContext as MealOrderApp).daggerAppComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentMenuBinding.bind(view)

        binding.mealsRecycler.adapter = MealsAdapter()

        binding.categoryTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewModel.loadMeals(tab.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        viewModel.meals.observe(viewLifecycleOwner) { meals ->
            (binding.mealsRecycler.adapter as MealsAdapter).items = meals
        }

        viewModel.categories.observe(viewLifecycleOwner) { mealCategories ->
            mealCategories.forEachIndexed { i, category ->
                binding.categoryTabs.addTab(
                    binding.categoryTabs.newTab().apply {
                        text = category.strCategory
                    },
                    (savedInstanceState?.getInt(TAB_POSITION_KEY) ?: 0) == i
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(TAB_POSITION_KEY, binding.categoryTabs.selectedTabPosition)
    }

    private companion object {
        private const val TAB_POSITION_KEY = "tab position"
    }

}
