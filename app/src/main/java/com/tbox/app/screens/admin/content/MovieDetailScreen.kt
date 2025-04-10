package com.tbox.app.screens.admin.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.tbox.app.model.Movie

@Composable
fun MovieDetailScreen(
    movie: Movie,
    onEdit: (Movie) -> Unit,
    onDelete: (Movie) -> Unit,
    onBack: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = movie.title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = rememberAsyncImagePainter(movie.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = movie.description,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = onBack) {
                Text("חזרה")
            }
            Button(onClick = { onEdit(movie) }) {
                Text("עריכה")
            }
            Button(
                onClick = { onDelete(movie) },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("מחיקה")
            }
        }
    }
}
