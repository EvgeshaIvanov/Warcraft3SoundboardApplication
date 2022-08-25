package com.evgeshaog.warcraft3soundboardapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayAlliancePackSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayHordePackSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayNightElfSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayUndeadSoundUseCase
import javax.inject.Inject

class WarcraftViewModelFactory @Inject constructor(
    private val playAlliancePackSoundUseCase: PlayAlliancePackSoundUseCase,
    private val playHordePackSoundUseCase: PlayHordePackSoundUseCase,
    private val playNightElfSoundUseCase: PlayNightElfSoundUseCase,
    private val playUndeadSoundUseCase: PlayUndeadSoundUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                playAlliancePackSoundUseCase,
                playHordePackSoundUseCase,
                playNightElfSoundUseCase,
                playUndeadSoundUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

    class Factory @Inject constructor(
        private val playAlliancePackSoundUseCase: PlayAlliancePackSoundUseCase,
        private val playHordePackSoundUseCase: PlayHordePackSoundUseCase,
        private val playNightElfSoundUseCase: PlayNightElfSoundUseCase,
        private val playUndeadSoundUseCase: PlayUndeadSoundUseCase
    ) {
        fun create(): WarcraftViewModelFactory {
            return WarcraftViewModelFactory(
                playAlliancePackSoundUseCase,
                playHordePackSoundUseCase,
                playNightElfSoundUseCase,
                playUndeadSoundUseCase
            )
        }
    }
}