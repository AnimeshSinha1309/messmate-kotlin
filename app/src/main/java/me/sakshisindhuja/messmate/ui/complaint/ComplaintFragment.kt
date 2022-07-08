package me.sakshisindhuja.messmate.ui.complaint

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import me.sakshisindhuja.messmate.R
import me.sakshisindhuja.messmate.databinding.FragmentComplaintBinding

import me.sakshisindhuja.messmate.datamodels.ComplaintsDataInterface


class ComplaintFragment : Fragment() {

    private var _binding: FragmentComplaintBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComplaintBinding.inflate(inflater, container, false)
        binding.inputComplaintSubmissionButton.setOnClickListener { view ->
            val selectedButton: RadioButton = requireView().findViewById(binding.inputComplaintMealType.checkedRadioButtonId)
            val complaintSummary: String = binding.inputComplaintSummary.text.toString()
            val mealType: String = selectedButton.text.toString()
            val addressImmediately: Boolean = binding.inputComplaintEmergencySwitch.isPressed
            ComplaintsDataInterface().writeComplaint(
                requireContext(), complaintSummary, mealType, addressImmediately)
            view.findNavController().navigate(R.id.nav_home)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}