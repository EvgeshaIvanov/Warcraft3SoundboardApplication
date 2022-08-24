package com.evgeshaog.iswarandcraftsoundboardapplication.domain.repository

import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.SoundboardItemModel

interface Repository {

    fun allianceSoundboardItems(): List<SoundboardItemModel>

    fun hordeSoundboardItems(): List<SoundboardItemModel>

    fun nightElfSoundboardItems(): List<SoundboardItemModel>

    fun undeadSoundboardItems(): List<SoundboardItemModel>

}