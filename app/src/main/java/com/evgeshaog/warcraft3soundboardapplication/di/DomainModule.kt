package com.evgeshaog.warcraft3soundboardapplication.di

import com.evgeshaog.warcraft3soundboardapplication.domain.repository.Repository
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayAlliancePackSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayHordePackSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayNightElfSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayUndeadSoundUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providePlayAlliancePackSoundUseCase(repository: Repository): PlayAlliancePackSoundUseCase {
        return PlayAlliancePackSoundUseCase(repository)
    }

    @Provides
    fun providePlayHordePackSoundUseCase(repository: Repository): PlayHordePackSoundUseCase {
        return PlayHordePackSoundUseCase(repository)
    }

    @Provides
    fun providePlayNightElfSoundUseCase(repository: Repository): PlayNightElfSoundUseCase {
        return PlayNightElfSoundUseCase(repository)
    }

    @Provides
    fun providePlayUndeadSoundUseCase(repository: Repository): PlayUndeadSoundUseCase {
        return PlayUndeadSoundUseCase(repository)
    }
}