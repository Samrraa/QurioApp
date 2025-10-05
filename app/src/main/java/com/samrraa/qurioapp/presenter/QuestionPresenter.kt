package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.model.FakeQuizRepository
import com.samrraa.qurioapp.view.question.IQuestionView

class QuestionPresenter(
    view: IQuestionView,
    private val repository: FakeQuizRepository = FakeQuizRepository()
) : BasePresenter<IQuestionView>(view) {
    fun getQuestions() {
        tryToExecute(
            execute = repository::getQuestions,
            onSuccess = { questions ->
                view?.onGetQuestionsSuccess(questions)
            },
        )
    }
}

