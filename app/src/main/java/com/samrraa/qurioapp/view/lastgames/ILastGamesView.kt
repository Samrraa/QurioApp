package com.samrraa.qurioapp.view.lastgames

import com.samrraa.qurioapp.base.BaseView
import com.samrraa.qurioapp.view.lastgames.model.History

interface ILastGamesView : BaseView {

    fun onGetLastGamesSuccess(games: List<History>)
}