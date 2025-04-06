package com.myflix.app.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00E5FF),
    secondary = Color(0xFF00B8D4),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun MyFlixTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = DarkColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
