package com.enrique.pokedex

import android.app.Application
import com.enrique.pokedex.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    private fun configureDI() = startKoin {
        androidContext(this@App)
        modules(appComponent)
    }
}
