package com.evgeshaog.warcraft3soundboardapplication.domain.repository

import com.evgeshaog.warcraft3soundboardapplication.domain.model.SoundboardItemModel

interface Repository {

    fun allianceSoundboardItems(): List<SoundboardItemModel>

    fun hordeSoundboardItems(): List<SoundboardItemModel>

    fun nightElfSoundboardItems(): List<SoundboardItemModel>

    fun undeadSoundboardItems(): List<SoundboardItemModel>

}