package com.evgeshaog.iswarandcraftsoundboardapplication.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.evgeshaog.iswarandcraftsoundboardapplication.R
import com.evgeshaog.iswarandcraftsoundboardapplication.core.SoundboardPagerAdapter
import com.evgeshaog.iswarandcraftsoundboardapplication.databinding.ActivityMainBinding
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.WarcraftMediaPlayer.clearMediaPlayer
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.WarcraftMediaPlayer.mediaPlayer
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.wc3_blue)
        binding.pager.adapter = SoundboardPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = ALLIANCE
                1 -> tab.text = HORDE
                2 -> tab.text = ELFS
                3 -> tab.text = UNDEAD
            }
        }.attach()

        binding.floatingButton.setOnClickListener {
            if (mediaPlayer != null) {
                clearMediaPlayer()
            }
        }
    }

    companion object {
        const val ALLIANCE = "Альянс"
        const val HORDE = "Орда"
        const val ELFS = "Эльфы"
        const val UNDEAD = "Нежить"
    }

}