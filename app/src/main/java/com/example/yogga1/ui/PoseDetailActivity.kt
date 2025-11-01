package com.example.yogga1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import com.example.yogga1.R
import com.example.yogga1.model.YogaPose
import com.example.yogga1.service.AudioManager
import com.example.yogga1.service.VideoPlayerHelper

class PoseDetailActivity : AppCompatActivity() {

    private lateinit var audioManager: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pose_detail)

        audioManager = AudioManager.getInstance()

        val pose = intent.getSerializableExtra("pose") as? YogaPose
        if (pose != null) {
            setupPoseDetails(pose)
            setupAudioButton(pose)
            setupVideoButton(pose)
        }
    }

    private fun setupPoseDetails(pose: YogaPose) {
        findViewById<TextView>(R.id.poseName).text = pose.name
        findViewById<TextView>(R.id.sanskritName).text = pose.sanskritName
        findViewById<TextView>(R.id.poseDescription).text = pose.description
        findViewById<TextView>(R.id.poseDifficulty).text = "Уровень: ${pose.difficulty}"
        // Убрали ImageView так как теперь используем VideoView
    }

    private fun setupAudioButton(pose: YogaPose) {
        val playButton = findViewById<Button>(R.id.playAudioButton)
        playButton.setOnClickListener {
            audioManager.playAudio(this, pose.audioResource)
        }
    }

    private fun setupVideoButton(pose: YogaPose) {
        val playVideoButton = findViewById<Button>(R.id.playVideoButton)
        val videoView = findViewById<VideoView>(R.id.poseVideo)

        playVideoButton.setOnClickListener {
            println("🎯 Нажата кнопка видео! ID ресурса: ${pose.videoResource}")

            // ТЕСТ 1: Пробуем твое видео
            val videoPath = "android.resource://${packageName}/${pose.videoResource}"
            println("📹 Путь к видео: $videoPath")

            videoView.setVideoPath(videoPath)

            videoView.setOnPreparedListener { mp ->
                println("✅ УСПЕХ! Видео готово к воспроизведению!")
                videoView.visibility = View.VISIBLE
                videoView.start()
                Toast.makeText(this, "Видео запущено!", Toast.LENGTH_SHORT).show()
            }

            videoView.setOnErrorListener { mp, what, extra ->
                println("❌ ОШИБКА ВИДЕО: what=$what, extra=$extra")

                // ТЕСТ 2: Пробуем онлайн видео для сравнения
                println("🔄 Пробую онлайн видео...")
                val testVideo =
                    "https://www.sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4"
                videoView.setVideoPath(testVideo)

                videoView.setOnPreparedListener { mp ->
                    println("✅ ОНЛАЙН ВИДЕО РАБОТАЕТ! Значит проблема в твоих файлах")
                    videoView.start()
                    Toast.makeText(this, "Онлайн видео работает!", Toast.LENGTH_LONG).show()
                }

                true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        audioManager.stopAudio()
    }
}