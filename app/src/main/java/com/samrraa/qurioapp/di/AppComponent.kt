package com.samrraa.qurioapp.di

import com.samrraa.qurioapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}
