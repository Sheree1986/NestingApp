// File: ui/theme/Theme.kt
package com.example.puzzlegame.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Simple color schemes for your puzzle game
private val DarkColors = darkColorScheme(
    primary = Color(0xFF4CAF50),        // Green
    secondary = Color(0xFF2196F3),      // Blue
    background = Color(0xFF2C3E50),     // Dark blue-gray
    surface = Color(0xFF34495E),        // Lighter gray
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF4CAF50),        // Green
    secondary = Color(0xFF2196F3),      // Blue
    background = Color(0xFFF5F5F5),     // Light gray
    surface = Color.White,              // White
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun PuzzleGameTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}