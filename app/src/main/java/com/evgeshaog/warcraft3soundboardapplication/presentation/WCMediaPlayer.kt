package com.evgeshaog.warcraft3soundboardapplication.presentation

import android.content.Context
import android.media.MediaPlayer
import com.evgeshaog.warcraft3soundboardapplication.domain.model.SoundboardItemModel

class WCMediaPlayer {

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