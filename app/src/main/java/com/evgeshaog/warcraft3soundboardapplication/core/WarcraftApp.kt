package com.evgeshaog.warcraft3soundboardapplication.core

import android.app.Application
import android.content.Context
import com.evgeshaog.warcraft3soundboardapplication.di.AppComponent
import com.evgeshaog.warcraft3soundboardapplication.di.DaggerAppComponent

class WarcraftApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is WarcraftApp -> appComponent
        else -> this.applicationContext.appComponent
    }