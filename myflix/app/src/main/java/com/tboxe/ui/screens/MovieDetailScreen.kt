package com.tboxe.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.tboxe.model.Movie
import com.tboxe.ui.theme.TBoxeTheme

@Composable
fun MovieDetailScreen(movie: Movie) {
    val context = LocalContext.current

    TBoxeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(movie.posterUrl),
                    contentDescription = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Genre: ${movie.genre}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = movie.description,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setDataAndType(Uri.parse(movie.m3u8Url), "video/*")
                        context.startActivity(intent)
                    }
                ) {
                    Text("צפה עכשיו")
                }
            }
        }
    }
}
