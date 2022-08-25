package com.evgeshaog.warcraft3soundboardapplication.presentation.alliance

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.evgeshaog.warcraft3soundboardapplication.core.SoundboardAdapter
import com.evgeshaog.warcraft3soundboardapplication.core.appComponent
import com.evgeshaog.warcraft3soundboardapplication.databinding.FragmentAllianceSoundboardBinding
import com.evgeshaog.warcraft3soundboardapplication.presentation.WarcraftMediaPlayer.clearMediaPlayer
import com.evgeshaog.warcraft3soundboardapplication.presentation.WarcraftMediaPlayer.mediaPlayer
import com.evgeshaog.warcraft3soundboardapplication.presentation.WarcraftMediaPlayer.startMediaPlayer
import com.evgeshaog.warcraft3soundboardapplication.presentation.viewmodel.MainViewModel
import com.evgeshaog.warcraft3soundboardapplication.presentation.viewmodel.WarcraftViewModelFactory
import javax.inject.Inject


class AllianceSoundboard : Fragment() {

    private lateinit var itemsAdapter: SoundboardAdapter

    private lateinit var binding: FragmentAllianceSoundboardBinding

    @Inject
    lateinit var factory: WarcraftViewModelFactory.Factory

    private val viewModel: MainViewModel by viewModels {
        factory.create()
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

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