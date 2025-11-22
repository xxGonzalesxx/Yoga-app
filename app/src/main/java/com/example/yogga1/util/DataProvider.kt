package com.example.yogga1.util

import com.example.yogga1.R
import com.example.yogga1.model.YogaPose

object DataProvider {
    val yogaPoses = listOf(
        YogaPose(
            id = 1,
            name = "Поза Горы",
            sanskritName = "Тадасана",
            description = "Базовая стоячая поза, основа для всех стоячих асан. Улучшает осанку, укрепляет ноги и живот.",
            difficulty = "Начальный",
            imageResource = R.drawable.tree_pose,
            audioResource = R.raw.mountain_pose_audio,
            videoResource = R.raw.mountain_pose_video
        ),
        YogaPose(
            id = 2,
            name = "Поза Собаки Мордой Вниз",
            sanskritName = "Адхо Мукха Шванасана",
            description = "Растягивает спину, ноги и плечи. Улучшает кровообращение и снимает усталость.",
            difficulty = "Начальный",
            imageResource = R.drawable.cobra_pose,
            audioResource = R.raw.dog_pose_audio,
            videoResource = R.raw.mountain_pose_video // Временно используем то же видео
        ),
        YogaPose(
            id = 3,
            name = "Поза Воина",
            sanskritName = "Вирабхадрасана",
            description = "Сильная поза, развивающая выносливость. Укрепляет ноги и улучшает концентрацию.",
            difficulty = "Средний",
            imageResource = R.drawable.crescent_pose,
            audioResource = R.raw.warrior_pose_audio,
            videoResource = R.raw.warrior_pose_video
        ),
        YogaPose(
            id = 4,
            name = "Поза Ребенка",
            sanskritName = "Баласана",
            description = "Расслабляющая поза для отдыха между сложными асанами. Снимает напряжение в спине.",
            difficulty = "Начальный",
            imageResource = R.drawable.child_pose,
            audioResource = R.raw.mountain_pose_audio,
            videoResource = R.raw.tree_pose_video // Временно используем другое видео
        ),
        YogaPose(
            id = 5,
            name = "Поза Кобры",
            sanskritName = "Бхуджангасана",
            description = "Поза для укрепления мышц спины и раскрытия грудной клетки. Улучшает гибкость позвоночника.",
            difficulty = "Начальный",
            imageResource = R.drawable.cobra_pose,
            audioResource = R.raw.mountain_pose_audio,
            videoResource = R.raw.tree_pose_video // Временно используем другое видео
        ),
        YogaPose(
            id = 6,
            name = "Поза Дерева",
            sanskritName = "Врикшасана",
            description = "Поза баланса, улучшающая концентрацию и укрепляющая ноги. Развивает чувство равновесия.",
            difficulty = "Средний",
            imageResource = R.drawable.tree_pose,
            audioResource = R.raw.mountain_pose_audio,
            videoResource = R.raw.tree_pose_video
        )
    )
}