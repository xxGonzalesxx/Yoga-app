package com.example.yogga1.util

import com.example.yogga1.model.YogaPose
import com.example.yogga1.R

object DataProvider {
    fun getYogaPoses(): List<YogaPose> {
        return listOf(
            YogaPose(
                id = 1,
                name = "Поза Горы",
                sanskritName = "Тадасана",
                description = "Встаньте прямо, стопы вместе",
                difficulty = "Начальный",
                imageResource = R.drawable.ic_launcher_foreground,
                audioResource = R.raw.mountain_pose_audio,
                videoResource = R.raw.mountain_pose_video
            ),
            YogaPose(
                id = 2,
                name = "Поза Собаки Мордой Вниз",
                sanskritName = "Адхо Мукха Шванасана",
                description = "Из положения на четвереньках поднимите таз",
                difficulty = "Начальный",
                imageResource = R.drawable.ic_launcher_foreground,
                audioResource = R.raw.dog_pose_audio,
                videoResource = R.raw.dog_pose_audio
            ),
            YogaPose(
                id = 3,
                name = "Поза Воина",
                sanskritName = "Вирабхадрасана",
                description = "Широкий выпад с поднятыми руками",
                difficulty = "Средний",
                imageResource = R.drawable.ic_launcher_foreground,
                audioResource = R.raw.warrior_pose_audio,
                videoResource = R.raw.warrior_pose_audio
            )
        )
    }
}
