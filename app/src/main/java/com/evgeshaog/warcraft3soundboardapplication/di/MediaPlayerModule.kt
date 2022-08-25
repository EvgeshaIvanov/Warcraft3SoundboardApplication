package com.evgeshaog.warcraft3soundboardapplication.di

import android.media.MediaPlayer
import com.evgeshaog.warcraft3soundboardapplication.presentation.WCMediaPlayer
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MediaPlayerModule {

    @Provides
    @Singleton
    fun provideMediaPlayer(): MediaPlayer? {
        return WCMediaPlayer().mediaPlayer
    }

    @Provides
    @Singleton
    fun provideWCMediaPlayer(): WCMediaPlayer {
        return WCMediaPlayer()
    }

}