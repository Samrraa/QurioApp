package com.samrraa.qurioapp.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentOnboardingBinding
import com.samrraa.qurioapp.presenter.OnboardingPresenter

class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding, IOnboardingView, OnboardingPresenter>(),
    IOnboardingView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.setOnClickListener {
            findNavController().navigate(OnboardingFragmentDirections.actionOnboardingFragmentToHomeFragment())
        }
    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnboardingBinding {
        TODO("Not yet implemented")
    }

    override fun initPresenter(): OnboardingPresenter = presenter
}