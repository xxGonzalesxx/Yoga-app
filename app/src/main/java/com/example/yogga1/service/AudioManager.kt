package com.example.yogga1.service

import android.content.Context
import android.media.MediaPlayer

class  AudioManager private constructor() {
    private var mediaPlayer: MediaPlayer? = null

    fun playAudio(context: Context, audioResourceId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, audioResourceId)
        mediaPlayer?.start()
    }

    fun stopAudio() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    companion object {
        @Volatile
        private var INSTANCE: AudioManager? = null

        fun getInstance(): AudioManager =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: AudioManager().also { INSTANCE = it }
            }
    }
}
