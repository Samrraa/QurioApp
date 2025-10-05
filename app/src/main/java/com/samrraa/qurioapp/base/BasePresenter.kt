package com.samrraa.qurioapp.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

abstract class BasePresenter<VIEW : BaseView>(protected var view: VIEW?) {
    private val job = SupervisorJob()
    fun clear() {
        view = null
        job.cancel()
    }

    protected fun <T> tryToExecute(
        execute: suspend () -> T,
        onSuccess: ((T) -> Unit) = {},
        onError: (Throwable) -> Unit = {},
        onStart: suspend () -> Unit = {},
        onFinally: () -> Unit = {},
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ): Job {
        val handler = CoroutineExceptionHandler { _, throwable ->
            onError(
                throwable
            )
        }
        return CoroutineScope(dispatcher + job + handler).launch {
            onStart()
            runCatching { execute() }
                .onSuccess(onSuccess)
                .onFailure(onError)
            onFinally()
        }
    }
}