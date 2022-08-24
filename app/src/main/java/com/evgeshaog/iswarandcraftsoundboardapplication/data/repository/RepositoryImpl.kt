package com.evgeshaog.iswarandcraftsoundboardapplication.data.repository

import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.allianceSoundPack
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.hordeSoundPack
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.nightElfSoundPack
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.undeadSoundPack
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.repository.Repository

class RepositoryImpl : Repository {

    override fun allianceSoundboardItems() = allianceSoundPack

    override fun hordeSoundboardItems() = hordeSoundPack

    override fun nightElfSoundboardItems() = nightElfSoundPack

    override fun undeadSoundboardItems() = undeadSoundPack

}