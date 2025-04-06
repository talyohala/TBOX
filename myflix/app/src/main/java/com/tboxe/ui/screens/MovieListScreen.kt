package com.tboxe.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.tboxe.viewmodel.MovieViewModel

@Composable
fun MovieListScreen(navController: NavController, viewModel: MovieViewModel) {
    val movies = viewModel.movies.collectAsState().value
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("רשימת סרטים") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(movies) { movie ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // כאן תוכל להוסיף ניתוב לצפייה או פרטים
                        },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(movie.imageUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .size(90.dp)
                                .padding(end = 12.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column {
                            Text(text = movie.name, style = MaterialTheme.typography.titleMedium)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = movie.link, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}
