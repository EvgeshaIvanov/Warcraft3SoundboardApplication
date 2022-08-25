package com.evgeshaog.warcraft3soundboardapplication.domain.usecase

import com.evgeshaog.warcraft3soundboardapplication.domain.model.SoundboardItemModel
import com.evgeshaog.warcraft3soundboardapplication.domain.repository.Repository

class PlayHordePackSoundUseCase(private val repository: Repository) {

    fun execute(): List<SoundboardItemModel> {
        return repository.hordeSoundboardItems()
    }

}