package com.tbox.app.admin

import androidx.compose.foundation.layout.* import androidx.compose.foundation.lazy.LazyColumn import androidx.compose.foundation.text.BasicTextField import androidx.compose.material3.* import androidx.compose.runtime.* import androidx.compose.ui.Modifier import androidx.compose.ui.unit.dp import androidx.compose.ui.text.input.TextFieldValue import androidx.lifecycle.viewmodel.compose.viewModel import com.tbox.app.viewmodel.ContentViewModel

@Composable fun ContentManagementScreen(viewModel: ContentViewModel = viewModel()) { val uiState by viewModel.uiState.collectAsState() var newTitle by remember { mutableStateOf(TextFieldValue()) } var newUrl by remember { mutableStateOf(TextFieldValue()) }

Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    Text("ניהול תוכן", style = MaterialTheme.typography.headlineSmall)
    Spacer(modifier = Modifier.height(16.dp))

    BasicTextField(
        value = newTitle,
        onValueChange = { newTitle = it },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        decorationBox = { innerTextField ->
            Box(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                if (newTitle.text.isEmpty()) Text("שם הסרט")
                innerTextField()
            }
        }
    )

    BasicTextField(
        value = newUrl,
        onValueChange = { newUrl = it },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        decorationBox = { innerTextField ->
            Box(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                if (newUrl.text.isEmpty()) Text("קישור לסרט")
                innerTextField()
            }
        }
    )

    Button(onClick = {
        viewModel.addMovie(newTitle.text, newUrl.text)
        newTitle = TextFieldValue()
        newUrl = TextFieldValue()
    }) {
        Text("הוסף סרט")
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text("רשימת סרטים קיימים:", style = MaterialTheme.typography.titleMedium)
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(uiState.movies.size) { index ->
            val movie = uiState.movies[index]
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(movie.title)
                Button(onClick = { viewModel.deleteMovie(movie) }) {
                    Text("מחק")
                }
            }
        }
    }
}

}

