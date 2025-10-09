package com.samrraa.qurioapp.view.gameresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentGameResultBinding
import com.samrraa.qurioapp.presenter.GameResultPresenter
import com.samrraa.qurioapp.repository.GameRepository
import javax.inject.Inject

class GameResultFragment :
    BaseFragment<FragmentGameResultBinding, IGameResultView, GameResultPresenter>(),
    IGameResultView {

    @Inject
    lateinit var repository: GameRepository

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGameResultBinding {
        TODO("Not yet implemented")
    }

    override fun initPresenter(): GameResultPresenter = GameResultPresenter(repository, this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}