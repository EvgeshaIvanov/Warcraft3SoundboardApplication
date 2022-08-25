package com.evgeshaog.warcraft3soundboardapplication.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evgeshaog.warcraft3soundboardapplication.domain.model.SoundboardItemModel
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayAlliancePackSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayHordePackSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayNightElfSoundUseCase
import com.evgeshaog.warcraft3soundboardapplication.domain.usecase.PlayUndeadSoundUseCase

class MainViewModel(
    private val playAlliancePackSoundUseCase: PlayAlliancePackSoundUseCase,
    private val playHordePackSoundUseCase: PlayHordePackSoundUseCase,
    private val playNightElfSoundUseCase: PlayNightElfSoundUseCase,
    private val playUndeadSoundUseCase: PlayUndeadSoundUseCase
) : ViewModel() {

    val allianceSoundboardItemsList = MutableLiveData<List<SoundboardItemModel>>()

    val hordeSoundboardItemsList = MutableLiveData<List<SoundboardItemModel>>()

    val nightElfSoundboardItemsList = MutableLiveData<List<SoundboardItemModel>>()

    val undeadSoundboardItemsList = MutableLiveData<List<SoundboardItemModel>>()

    init {
        soundsItems()
    }

    private fun soundsItems() {
        val allianceList = playAlliancePackSoundUseCase.execute()
        val hordeList = playHordePackSoundUseCase.execute()
        val nightElfList = playNightElfSoundUseCase.execute()
        val undeadList = playUndeadSoundUseCase.execute()
        allianceSoundboardItemsList.value = allianceList
        hordeSoundboardItemsList.value = hordeList
        nightElfSoundboardItemsList.value = nightElfList
        undeadSoundboardItemsList.value = undeadList
    }


}