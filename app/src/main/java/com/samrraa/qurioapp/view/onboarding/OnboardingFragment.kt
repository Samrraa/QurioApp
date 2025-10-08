package com.samrraa.qurioapp.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.samrraa.qurioapp.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!
    private lateinit var onboardingAdapter: OnboardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        setupButtons()
    }

    private fun setupViewPager() {
        onboardingAdapter = OnboardingAdapter()
        binding.onboardingViewPager.adapter = onboardingAdapter

        binding.onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateButtonVisibility(position)
            }
        })

        updateButtonVisibility(0)
    }

    private fun setupButtons() {
        binding.btnPrev.setOnClickListener {
            val currentItem = binding.onboardingViewPager.currentItem
            if (currentItem > 0) binding.onboardingViewPager.currentItem = currentItem - 1
            else requireActivity().finish()
        }

        binding.btnNext.setOnClickListener {
            val currentItem = binding.onboardingViewPager.currentItem
            val itemCount = onboardingAdapter.itemCount

            if (currentItem < itemCount - 1) binding.onboardingViewPager.currentItem = currentItem + 1
            else navigateToHome()
        }

        binding.root.addSwipeUpGesture {
            val currentItem = binding.onboardingViewPager.currentItem
            val itemCount = onboardingAdapter.itemCount
            if (currentItem == itemCount - 1) {
                navigateToHome()
            }
        }
    }

    private fun updateButtonVisibility(position: Int) {
        binding.btnPrev.isVisible = true
        binding.btnNext.isVisible = true
    }

    private fun navigateToHome() {
        saveOnboardingComplete()

        findNavController().navigate(
            OnboardingFragmentDirections.actionOnboardingFragmentToHomeFragment()
        )
    }

    private fun saveOnboardingComplete() {
        requireContext().getSharedPreferences("qurio_prefs", android.content.Context.MODE_PRIVATE)
            .edit {
                putBoolean("onboarding_complete", true)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
