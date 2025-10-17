package com.samrraa.qurioapp.view.lastgames.model

data class History(
    val id: Int,
    val date: Long = System.currentTimeMillis(),
    val coin: Int,
    val star: Int,
    val subjectStringRes: Int,
    val time: Int
)