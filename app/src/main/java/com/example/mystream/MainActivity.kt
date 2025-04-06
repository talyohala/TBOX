package com.example.mystream

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStreamApp()
        }
    }
}

@Composable
fun MyStreamApp() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MyStreamApp") })
        }
    ) { padding ->
        Text(
            text = "ברוך הבא לסטרימינג!",
            modifier = Modifier.padding(padding)
        )
    }
}

@Preview
@Composable
fun PreviewApp() {
    MyStreamApp()
}
