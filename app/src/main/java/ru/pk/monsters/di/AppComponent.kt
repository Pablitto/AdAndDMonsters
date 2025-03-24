package ru.pk.monsters.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.pk.monsters.presentation.MainActivity
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    companion object {
        private var appComponent: AppComponent? = null

        fun create(application: Application) = appComponent ?: DaggerAppComponent
            .factory()
            .create(application.applicationContext)
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @Named("AppContext")
            context: Context
        ): AppComponent
    }

    fun inject(activity: MainActivity)
}