package com.samrraa.qurioapp.view.mapper.lastgame

import com.samrraa.qurioapp.model.GameResult
import com.samrraa.qurioapp.view.lastgames.model.History


fun GameResult.toHistoryUi(): History {
    return History(
        id = id,
        date = date,
        coin = coinsCount,
        star = starsCount,
        subject = category,
        time = durationInSeconds
    )

}

fun List<GameResult>.toHistoryUi() = map { it.toHistoryUi() }