package com.samrraa.qurioapp.datasource.remote.api

import com.samrraa.qurioapp.datasource.remote.dto.QuestionResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApiService {
    @GET("api.php")
    fun getQuestions(
        @Query("amount") amount: Int? = null,
        @Query("category") category: Int? = null,
        @Query("difficulty") difficulty: String? = null,
        @Query("type") type: String? = null
    ): QuestionResponse
}