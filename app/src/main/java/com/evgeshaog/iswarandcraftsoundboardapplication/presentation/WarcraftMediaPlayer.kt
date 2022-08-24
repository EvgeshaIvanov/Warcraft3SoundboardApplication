package com.evgeshaog.iswarandcraftsoundboardapplication.presentation

import android.content.Context
import android.media.MediaPlayer
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.SoundboardItemModel

object WarcraftMediaPlayer {

    var mediaPlayer: MediaPlayer? = null

    fun startMediaPlayer(context: Context, item: SoundboardItemModel) {
        mediaPlayer = MediaPlayer.create(context, item.sound)
        mediaPlayer?.start()
    }

    fun clearMediaPlayer() {
        mediaPlayer!!.stop()
        mediaPlayer!!.reset()
        mediaPlayer!!.release()
        mediaPlayer = null
    }
}