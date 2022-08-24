package com.evgeshaog.iswarandcraftsoundboardapplication.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.alliance.AllianceSoundboard
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.elf.NightElfSoundboard
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.horde.HordeSoundboard
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.undead.UndeadSoundboard

class SoundboardPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllianceSoundboard()
            1 -> HordeSoundboard()
            2 -> NightElfSoundboard()
            3 -> UndeadSoundboard()
            else -> AllianceSoundboard()
        }
    }


}