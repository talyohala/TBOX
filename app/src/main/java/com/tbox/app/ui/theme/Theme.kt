package com.tbox.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple200,
    secondary = Teal200,
    background = Black,
    surface = Black,
    onPrimary = White,
    onSecondary = White,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple200,
    secondary = Teal200,
    background = White,
    surface = White,
    onPrimary = Black,
    onSecondary = Black,
)

@Composable
fun TBOXTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
