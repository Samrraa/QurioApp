package com.samrraa.qurioapp

import android.app.Application
import com.samrraa.qurioapp.di.AppComponent
import com.samrraa.qurioapp.di.DaggerAppComponent


class QurioApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .build()
    }
}