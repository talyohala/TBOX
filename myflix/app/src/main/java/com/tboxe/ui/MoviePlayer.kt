package com.tboxe.ui

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.android.exoplayer2.ui.PlayerView
import android.widget.FrameLayout
import android.view.ViewGroup.LayoutParams.MATCH_PARENT

class MoviePlayer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieUrl = intent.getStringExtra("url") ?: return
        val player = ExoPlayer.Builder(this).build()
        val mediaItem = MediaItem.fromUri(Uri.parse(movieUrl))
        player.setMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = true

        val playerView = PlayerView(this)
        playerView.player = player
        playerView.layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)

        setContentView(playerView)
    }
}
