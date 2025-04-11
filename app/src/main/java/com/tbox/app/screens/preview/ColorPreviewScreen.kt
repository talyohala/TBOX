package com.tbox.app.screens.preview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tbox.app.ui.theme.TBOXTheme

@Composable
fun ColorPreviewScreen() {
    val colors = listOf(
        "Primary" to MaterialTheme.colorScheme.primary,
        "OnPrimary" to MaterialTheme.colorScheme.onPrimary,
        "Secondary" to MaterialTheme.colorScheme.secondary,
        "OnSecondary" to MaterialTheme.colorScheme.onSecondary,
        "Tertiary" to MaterialTheme.colorScheme.tertiary,
        "OnTertiary" to MaterialTheme.colorScheme.onTertiary,
        "Background" to MaterialTheme.colorScheme.background,
        "OnBackground" to MaterialTheme.colorScheme.onBackground,
        "Surface" to MaterialTheme.colorScheme.surface,
        "OnSurface" to MaterialTheme.colorScheme.onSurface,
        "Error" to MaterialTheme.colorScheme.error,
        "OnError" to MaterialTheme.colorScheme.onError
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        colors.forEach { (name, color) ->
            ColorBox(name = name, color = color)
        }
    }
}

@Composable
fun ColorBox(name: String, color: Color) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        color = color,
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 2.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = name, color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewColorScreen() {
    TBOXTheme {
        ColorPreviewScreen()
    }
}
