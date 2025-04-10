package com.tbox.app.screens.admin.content.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.tbox.app.model.Movie

@Composable
fun MovieItemView(
    movie: Movie,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.height(120.dp)) {
            Image(
                painter = rememberAsyncImagePainter(movie.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = movie.genre,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
