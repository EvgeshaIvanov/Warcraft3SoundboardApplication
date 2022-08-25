package com.evgeshaog.warcraft3soundboardapplication.di

import com.evgeshaog.warcraft3soundboardapplication.presentation.alliance.AllianceSoundboard
import dagger.Component

@Component(modules = [MediaPlayerModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(allianceSoundboard: AllianceSoundboard)

}