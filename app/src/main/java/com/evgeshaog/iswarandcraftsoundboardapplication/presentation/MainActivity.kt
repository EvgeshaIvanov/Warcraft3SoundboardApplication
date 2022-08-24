package com.evgeshaog.iswarandcraftsoundboardapplication.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.evgeshaog.iswarandcraftsoundboardapplication.R
import com.evgeshaog.iswarandcraftsoundboardapplication.databinding.ActivityMainBinding
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.WarcraftMediaPlayer.clearMediaPlayer
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.WarcraftMediaPlayer.mediaPlayer
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.adapter.SoundboardPagerAdapter
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
                0 -> tab.text = "Альянс"
                1 -> tab.text = "Орда"
                2 -> tab.text = "Эльфы"
                3 -> tab.text = "Нежить"
            }
        }.attach()

        binding.floatingButton.setOnClickListener {
            if (mediaPlayer != null) {
                clearMediaPlayer()
            }
        }
    }

}