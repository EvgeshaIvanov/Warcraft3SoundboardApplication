package com.evgeshaog.warcraft3soundboardapplication.di

import com.evgeshaog.warcraft3soundboardapplication.data.repository.RepositoryImpl
import com.evgeshaog.warcraft3soundboardapplication.domain.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRepository(): Repository {
        return RepositoryImpl()
    }
}