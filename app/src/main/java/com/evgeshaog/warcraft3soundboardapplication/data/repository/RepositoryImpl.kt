package com.evgeshaog.warcraft3soundboardapplication.data.repository

import com.evgeshaog.warcraft3soundboardapplication.domain.model.allianceSoundPack
import com.evgeshaog.warcraft3soundboardapplication.domain.model.hordeSoundPack
import com.evgeshaog.warcraft3soundboardapplication.domain.model.nightElfSoundPack
import com.evgeshaog.warcraft3soundboardapplication.domain.model.undeadSoundPack
import com.evgeshaog.warcraft3soundboardapplication.domain.repository.Repository

class RepositoryImpl : Repository {

    override fun allianceSoundboardItems() = allianceSoundPack

    override fun hordeSoundboardItems() = hordeSoundPack

    override fun nightElfSoundboardItems() = nightElfSoundPack

    override fun undeadSoundboardItems() = undeadSoundPack

}