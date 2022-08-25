package com.evgeshaog.warcraft3soundboardapplication.presentation.elf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.evgeshaog.warcraft3soundboardapplication.core.SoundboardAdapter
import com.evgeshaog.warcraft3soundboardapplication.databinding.FragmentNightElfSoundboardBinding
import com.evgeshaog.warcraft3soundboardapplication.presentation.viewmodel.MainViewModel
import com.evgeshaog.warcraft3soundboardapplication.presentation.WCMediaPlayer
import javax.inject.Inject


class NightElfSoundboard : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var itemsAdapter: SoundboardAdapter

    private lateinit var binding: FragmentNightElfSoundboardBinding

    @Inject
    lateinit var media: WCMediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNightElfSoundboardBinding.inflate(inflater)
        itemsAdapter = SoundboardAdapter()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = itemsAdapter
        }
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.nightElfSoundboardItemsList.observe(viewLifecycleOwner) { list ->
            itemsAdapter.items = list
        }
        media = WCMediaPlayer()
        itemsAdapter.clickOnItem = { item ->
            if (media.mediaPlayer != null && media.mediaPlayer!!.isPlaying) {
                media.clearMediaPlayer()
                context?.let { media.startMediaPlayer(it, item) }
            } else {
                context?.let { media.startMediaPlayer(it, item) }
            }

        }
        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        if (media.mediaPlayer != null) {
            media.clearMediaPlayer()
        }
    }
}