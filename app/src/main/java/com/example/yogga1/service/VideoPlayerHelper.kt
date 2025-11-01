package com.example.yogga1.service

import android.net.Uri
import android.widget.VideoView

object VideoPlayerHelper {
    fun playVideo(videoUrl: String, videoView: VideoView) {
        val uri = Uri.parse("https://rutube.ru/video/e154dbf415f5bbe4b9524b8ed51f9585/")
        videoView.setVideoURI(uri)
        videoView.start()
    }
}
