package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.repository.GameRepository
import com.samrraa.qurioapp.view.home.IHomeView
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val repository: GameRepository,
    view: IHomeView
) : BasePresenter<IHomeView>(view) {

}