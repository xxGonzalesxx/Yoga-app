package com.example.yogga1.service

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class AudioManager private constructor() {
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false

    fun playAudio(context: Context, audioResourceId: Int) {
        try {
            // Останавливаем предыдущее воспроизведение
            stopAudio()

            mediaPlayer = MediaPlayer.create(context, audioResourceId)
            mediaPlayer?.setOnCompletionListener {
                isPlaying = false
                it.release()
            }
            mediaPlayer?.start()
            isPlaying = true

        } catch (e: Exception) {
            Log.e("AudioManager", "Ошибка воспроизведения аудио: ${e.message}")
            isPlaying = false
        }
    }

    fun stopAudio() {
        try {
            mediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
                it.release()
            }
            mediaPlayer = null
            isPlaying = false
        } catch (e: Exception) {
            Log.e("AudioManager", "Ошибка остановки аудио: ${e.message}")
        }
    }

    fun isPlaying(): Boolean = isPlaying

    companion object {
        @Volatile
        private var INSTANCE: AudioManager? = null

        fun getInstance(): AudioManager =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: AudioManager().also { INSTANCE = it }
            }
    }
}