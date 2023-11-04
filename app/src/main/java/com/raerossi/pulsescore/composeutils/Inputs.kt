package com.raerossi.pulsescore.composeutils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.R
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.neutralVariant95
import com.raerossi.pulsescore.ui.theme.primary40
import com.raerossi.pulsescore.ui.theme.primary50
import com.raerossi.pulsescore.ui.theme.primary60


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }

    TextField(
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp)
            )
            .border(
                width = 0.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(24.dp)
            ),
        value = name,
        onValueChange = { name = it },
        textStyle = MaterialTheme.typography.labelLarge,
        singleLine = true,
        enabled = true,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.padding(start = 6.dp),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search bar",
                    tint = MaterialTheme.colorScheme.primary60
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.primary40,
            placeholderColor = MaterialTheme.colorScheme.primary50,
            containerColor = MaterialTheme.colorScheme.neutralVariant95,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                modifier = Modifier.padding(start = 2.dp),
                text = "Search...",
                style = MaterialTheme.typography.labelLarge
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun InputsPreviews() {
    PulseScoreTheme {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
            SearchBar(
                Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 16.dp)
            )
        }
    }
}