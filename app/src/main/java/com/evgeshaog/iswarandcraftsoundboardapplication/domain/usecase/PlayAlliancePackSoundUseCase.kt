package com.evgeshaog.iswarandcraftsoundboardapplication.domain.usecase

import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.SoundboardItemModel
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.repository.Repository

class PlayAlliancePackSoundUseCase(private val repository: Repository) {

    fun execute(): List<SoundboardItemModel> {
        return repository.allianceSoundboardItems()
    }

}