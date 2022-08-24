package com.evgeshaog.iswarandcraftsoundboardapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evgeshaog.iswarandcraftsoundboardapplication.data.repository.RepositoryImpl
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.SoundboardItemModel
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.usecase.PlayAlliancePackSoundUseCase
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.usecase.PlayHordePackSoundUseCase
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.usecase.PlayNightElfSoundUseCase
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.usecase.PlayUndeadSoundUseCase

class MainViewModel : ViewModel() {

    private val repository = RepositoryImpl()

    private val playAlliancePackSoundUseCase = PlayAlliancePackSoundUseCase(repository)

    private val playHordePackSoundUseCase = PlayHordePackSoundUseCase(repository)

    private val playNightElfSoundUseCase = PlayNightElfSoundUseCase(repository)

    private val playUndeadSoundUseCase = PlayUndeadSoundUseCase(repository)

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