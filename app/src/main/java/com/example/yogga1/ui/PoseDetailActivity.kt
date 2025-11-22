package com.example.yogga1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import com.example.yogga1.R
import com.example.yogga1.model.YogaPose
import com.example.yogga1.service.AudioManager

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
            setupVideoButton(pose)  // Исправлено: убрал "Simple"
        } else {
            Toast.makeText(this, "Ошибка загрузки позы", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun setupPoseDetails(pose: YogaPose) {
        findViewById<TextView>(R.id.poseName).text = pose.name
        findViewById<TextView>(R.id.sanskritName).text = pose.sanskritName
        findViewById<TextView>(R.id.poseDescription).text = pose.description
        findViewById<TextView>(R.id.poseDifficulty).text = pose.difficulty
    }

    private fun setupAudioButton(pose: YogaPose) {
        val playButton = findViewById<Button>(R.id.playAudioButton)
        playButton.setOnClickListener {
            audioManager.playAudio(this, pose.audioResource)
            Toast.makeText(this, "Аудио инструкция", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupVideoButton(pose: YogaPose) {
        val playVideoButton = findViewById<Button>(R.id.playVideoButton)
        val videoView = findViewById<VideoView>(R.id.poseVideo)

        playVideoButton.setOnClickListener {
            try {
                // ПРОСТОЙ РАБОЧИЙ ВАРИАНТ
                val videoPath = "android.resource://${packageName}/${pose.videoResource}"
                videoView.setVideoPath(videoPath)
                videoView.start()
                videoView.visibility = android.view.View.VISIBLE
                Toast.makeText(this, "Видео запущено", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Ошибка видео", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        audioManager.stopAudio()
    }
}