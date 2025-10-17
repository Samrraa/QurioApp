package com.samrraa.qurioapp.di

import android.app.Application
import com.samrraa.qurioapp.MainActivity
import com.samrraa.qurioapp.view.games.GamesFragment
import com.samrraa.qurioapp.view.home.HomeFragment
import com.samrraa.qurioapp.view.lastgames.LastGamesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: GamesFragment)
    fun inject(fragment: LastGamesFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
