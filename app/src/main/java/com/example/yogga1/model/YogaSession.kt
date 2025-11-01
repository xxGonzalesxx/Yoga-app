package com.example.yogga1.model

data class YogaSession(
    val id: Int,
    val title: String,
    val duration: Int,
    val poses: List<YogaPose>
)
