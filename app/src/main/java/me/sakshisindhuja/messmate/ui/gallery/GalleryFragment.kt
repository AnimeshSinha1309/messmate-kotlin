package me.sakshisindhuja.messmate.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

import me.sakshisindhuja.messmate.databinding.FragmentGalleryBinding
import me.sakshisindhuja.messmate.MealsListAdapter
import me.sakshisindhuja.messmate.datamodels.TestDataModel


class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.mealsListRecyclerView
        val myDataset = TestDataModel().loadMealPlans(requireContext())
        recyclerView.adapter = MealsListAdapter(myDataset)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}