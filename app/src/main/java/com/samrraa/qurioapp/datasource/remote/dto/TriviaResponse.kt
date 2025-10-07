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
    val type: String? = null,

    @SerializedName("difficulty")
    val difficulty: String? = null,

    @SerializedName("category")
    val category: String? = null,

    @SerializedName("question")
    val question: String? = null,

    @SerializedName("correct_answer")
    val correctAnswer: String? = null,

    @SerializedName("incorrect_answers")
    val incorrectAnswers: List<String>? = null
)