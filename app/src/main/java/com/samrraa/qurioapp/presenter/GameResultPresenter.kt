package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.repository.GameRepository
import com.samrraa.qurioapp.view.gameresult.IGameResultView
import javax.inject.Inject

class GameResultPresenter @Inject constructor(
    private val repository: GameRepository,
    view: IGameResultView
) : BasePresenter<IGameResultView>(view) {
}