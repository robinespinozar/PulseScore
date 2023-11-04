package com.raerossi.pulsescore.views.preferences

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.R
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.neutral95
import com.raerossi.pulsescore.ui.theme.primary30
import com.raerossi.pulsescore.ui.theme.primary50

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SportItem(sport: String) {
    var isSelected by rememberSaveable { mutableStateOf(false) }
    FilterChip(
        modifier = Modifier
            .height(32.dp)
            .padding(end = 8.dp),
        selected = isSelected,
        onClick = { isSelected = !isSelected },
        colors = ChipDefaults.filterChipColors(
            backgroundColor = MaterialTheme.colorScheme.neutral95,
            contentColor = MaterialTheme.colorScheme.primary30,
            selectedBackgroundColor = MaterialTheme.colorScheme.primary50,
            selectedContentColor = MaterialTheme.colorScheme.neutral95
        )
    ) {
        Text(text = sport, style = MaterialTheme.typography.labelSmall)
    }
}


@Preview(showBackground = true)
@Composable
fun SportItemPreviews() {
    PulseScoreTheme {
        Column(
            Modifier.background(Color.White)
        ) {
            SportItem("Fútbol")
        }
    }
}