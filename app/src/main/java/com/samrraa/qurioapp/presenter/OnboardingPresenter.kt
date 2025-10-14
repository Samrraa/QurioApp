package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.view.onboarding.IOnboardingView
import javax.inject.Inject

class OnboardingPresenter @Inject constructor(view: IOnboardingView) :
    BasePresenter<IOnboardingView>(view) {
}