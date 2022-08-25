package com.evgeshaog.warcraft3soundboardapplication.presentation.undead

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.evgeshaog.warcraft3soundboardapplication.core.SoundboardAdapter
import com.evgeshaog.warcraft3soundboardapplication.databinding.FragmentUndeadSoundboardBinding
import com.evgeshaog.warcraft3soundboardapplication.presentation.viewmodel.MainViewModel
import com.evgeshaog.warcraft3soundboardapplication.presentation.WarcraftMediaPlayer.clearMediaPlayer
import com.evgeshaog.warcraft3soundboardapplication.presentation.WarcraftMediaPlayer.mediaPlayer
import com.evgeshaog.warcraft3soundboardapplication.presentation.WarcraftMediaPlayer.startMediaPlayer


class UndeadSoundboard : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var itemsAdapter: SoundboardAdapter

    private lateinit var binding: FragmentUndeadSoundboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUndeadSoundboardBinding.inflate(inflater)
        itemsAdapter = SoundboardAdapter()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = itemsAdapter
        }
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.undeadSoundboardItemsList.observe(viewLifecycleOwner) { list ->
            itemsAdapter.items = list
        }
        itemsAdapter.clickOnItem = { item ->
            if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                clearMediaPlayer()
                context?.let { startMediaPlayer(it, item) }
            } else {
                context?.let { startMediaPlayer(it, item) }
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer != null) {
            clearMediaPlayer()
        }
    }


}