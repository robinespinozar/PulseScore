package com.raerossi.pulsescore.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.backgroundGradient


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(backgroundGradient),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HOME",
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    PulseScoreTheme {
        HomeScreen()
    }
}