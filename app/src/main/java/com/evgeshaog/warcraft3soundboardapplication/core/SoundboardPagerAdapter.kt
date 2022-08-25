package com.evgeshaog.warcraft3soundboardapplication.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evgeshaog.warcraft3soundboardapplication.presentation.alliance.AllianceSoundboard
import com.evgeshaog.warcraft3soundboardapplication.presentation.elf.NightElfSoundboard
import com.evgeshaog.warcraft3soundboardapplication.presentation.horde.HordeSoundboard
import com.evgeshaog.warcraft3soundboardapplication.presentation.undead.UndeadSoundboard

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