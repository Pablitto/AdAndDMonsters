package ru.pk.monsters

import android.app.Application
import ru.pk.monsters.di.AppComponent

class MonstersApp: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.create(this)
    }

}