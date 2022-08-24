package com.evgeshaog.iswarandcraftsoundboardapplication.presentation.alliance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.evgeshaog.iswarandcraftsoundboardapplication.core.SoundboardAdapter
import com.evgeshaog.iswarandcraftsoundboardapplication.databinding.FragmentAllianceSoundboardBinding
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.MainViewModel
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.WarcraftMediaPlayer.clearMediaPlayer
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.WarcraftMediaPlayer.mediaPlayer
import com.evgeshaog.iswarandcraftsoundboardapplication.presentation.WarcraftMediaPlayer.startMediaPlayer


class AllianceSoundboard : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var itemsAdapter: SoundboardAdapter

    private lateinit var binding: FragmentAllianceSoundboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllianceSoundboardBinding.inflate(inflater)
        itemsAdapter = SoundboardAdapter()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = itemsAdapter
        }
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.allianceSoundboardItemsList.observe(viewLifecycleOwner) { list ->
            itemsAdapter.items = list
        }
        itemsAdapter.clickOnItem = { item ->
            if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                clearMediaPlayer()
                context?.let { startMediaPlayer(it, item) }
            } else {
                context?.let { startMediaPlayer(it, item) }
            }
            mediaPlayer?.setOnCompletionListener {
                clearMediaPlayer()
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