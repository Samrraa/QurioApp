package com.samrraa.qurioapp.di

import android.app.Application
import android.content.Context
import com.samrraa.qurioapp.datastore.QurioPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext

    @Provides
    @Singleton
    fun provideQurioPreferences(context: Context): QurioPreferences {
        return QurioPreferences(context)
    }

}