package com.example.puzzlegame.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.math.*

@Composable
fun AnimatedBackground(rotation: Float) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val centerX = size.width / 2f
        val centerY = size.height / 2f

        for (i in 0..5) {
            val angle = rotation + i * 60f
            val radius = 200f + i * 50f
            val x = centerX + cos(Math.toRadians(angle.toDouble())).toFloat() * radius
            val y = centerY + sin(Math.toRadians(angle.toDouble())).toFloat() * radius

            drawCircle(
                color = Color.White.copy(alpha = 0.05f),
                radius = 30f + i * 10f,
                center = androidx.compose.ui.geometry.Offset(x, y)
            )
        }
    }
}