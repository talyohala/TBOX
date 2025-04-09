package com.tbox.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var startAnimation by remember { mutableStateOf(false) }

            val alphaAnim by animateFloatAsState(
                targetValue = if (startAnimation) 1f else 0f,
                animationSpec = tween(durationMillis = 1000),
                label = "alphaAnim"
            )

            val scaleAnim by animateFloatAsState(
                targetValue = if (startAnimation) 1f else 0.7f,
                animationSpec = tween(durationMillis = 1000),
                label = "scaleAnim"
            )

            LaunchedEffect(Unit) {
                startAnimation = true
                delay(2000)
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(id = R.drawable.tbox_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(180.dp)
                        .scale(scaleAnim)
                        .alpha(alphaAnim)
                )
            }
        }
    }
}
