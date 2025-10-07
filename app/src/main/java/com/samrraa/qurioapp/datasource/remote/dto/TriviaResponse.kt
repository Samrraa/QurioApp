package com.samrraa.qurioapp.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class TriviaResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("results")
    val result: List<TriviaQuestion>
)

data class TriviaQuestion(

    @SerializedName("type")
    val type: String,

    @SerializedName("difficulty")
    val difficulty: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("question")
    val question: String,

    @SerializedName("correct_answer")
    val correctAnswer: String,

    @SerializedName("incorrect_answers")
    val incorrectAnswers: List<String>
)