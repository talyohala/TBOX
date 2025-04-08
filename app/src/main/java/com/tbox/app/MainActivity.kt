package com.tbox.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.tbox.app.ui.theme.TBOXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TBOXTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Text(text = "Welcome to TBOX Streaming App!")
                }
            }
        }
    }
}
