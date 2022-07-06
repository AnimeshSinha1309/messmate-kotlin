package me.sakshisindhuja.messmate.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

import me.sakshisindhuja.messmate.MealsListAdapter
import me.sakshisindhuja.messmate.databinding.FragmentFoodBinding
import me.sakshisindhuja.messmate.datamodels.MealsDataInterface


class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.mealsListRecyclerView
        val myDataset = MealsDataInterface().loadMealPlans(requireContext())
        recyclerView.adapter = MealsListAdapter(myDataset)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}