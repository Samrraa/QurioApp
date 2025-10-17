package com.samrraa.qurioapp.view.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentOnboardingBinding
import com.samrraa.qurioapp.presenter.OnboardingPresenter

class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding, IOnboardingView, OnboardingPresenter>(),
    IOnboardingView {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentOnboardingBinding.inflate(inflater, container, false)

    override fun initPresenter() = OnboardingPresenter(this)
}

    ): FragmentOnboardingBinding {
        return FragmentOnboardingBinding.inflate(inflater, container, false)
    }

    override fun initPresenter(): OnboardingPresenter = OnboardingPresenter(this)


    }
