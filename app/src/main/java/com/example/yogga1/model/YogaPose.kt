package com.example.yogga1.model

import java.io.Serializable

data class YogaPose(
    val id: Int,
    val name: String,
    val sanskritName: String,
    val description: String,
    val difficulty: String,
    val imageResource: Int,
    val audioResource: Int,
    val videoResource: Int
) : Serializable  // Только это!