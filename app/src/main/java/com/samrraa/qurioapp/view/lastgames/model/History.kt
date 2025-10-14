package com.samrraa.qurioapp.view.lastgames.model

import com.samrraa.qurioapp.model.GameCategory

data class History(
    val id: Int,
    val date: Long = System.currentTimeMillis(),
    val coin: Int,
    val star: Int,
    val subject: GameCategory,
    val time: Int
)