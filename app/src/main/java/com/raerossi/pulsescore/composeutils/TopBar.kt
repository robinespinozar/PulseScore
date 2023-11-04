package com.raerossi.pulsescore.composeutils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.R
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.md_light_description
import com.raerossi.pulsescore.ui.theme.md_theme_light_outlineVariant
import com.raerossi.pulsescore.ui.theme.md_theme_ref_neutralVariant_40
import com.raerossi.pulsescore.ui.theme.md_theme_ref_neutralVariant_95
import com.raerossi.pulsescore.ui.theme.md_theme_ref_primary50
import com.raerossi.pulsescore.ui.theme.neutralVariant95
import com.raerossi.pulsescore.ui.theme.onTopBarContainer
import com.raerossi.pulsescore.ui.theme.primary50
import com.raerossi.pulsescore.ui.theme.primaryGradient
import com.raerossi.pulsescore.ui.theme.topBarContainer
import com.raerossi.pulsescore.utils.InputFieldColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressTopBar(modifier: Modifier = Modifier, progress: Float = 0.4f) {
    var progressStatus by rememberSaveable { mutableStateOf(progress) }

    CenterAlignedTopAppBar(
        modifier = modifier
            .shadow(ShadowSizes.smSize)
            .height(48.dp),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topBarContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.primary50
        ),
        title = {
            TopBarProgressBar(progress = progressStatus)
        },
        navigationIcon = {
            TopBarNavigationIcon(
                icon = R.drawable.ic_back_arrow,
                onClick = { /*TODO*/ })
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier
            .shadow(ShadowSizes.smSize)
            .height(48.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topBarContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.primary50
        ),
        title = {
            TopBarTitleText(text = "Centered Top App Bar")
        },
        navigationIcon = {
            TopBarNavigationIcon(
                icon = R.drawable.ic_back_arrow,
                onClick = { /*TODO*/ })
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleWithActionsTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier
            .shadow(ShadowSizes.smSize)
            .height(48.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topBarContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.primary50,
            actionIconContentColor = MaterialTheme.colorScheme.primary50
        ),
        title = {
            TopBarTitleText(text = "Centered Top App Bar")
        },
        navigationIcon = {
            TopBarNavigationIcon(
                icon = R.drawable.ic_back_arrow,
                onClick = { /*TODO*/ })
        },
        actions = {
            TopBarActionIcon(
                icon = R.drawable.ic_search,
                onClick = { /*TODO*/ })
        }
    )
}

@Composable
fun TopBarTitleText(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(modifier = modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
        Text(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onTopBarContainer
        )
    }
}

@Composable
fun TopBarProgressBar(
    modifier: Modifier = Modifier,
    progress: Float
) {
    Box(modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier.background(
                color = Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
        ) {
            LinearProgressIndicator(
                modifier = Modifier
                    .height(5.dp)
                    .width(175.dp),
                progress = progress,
                color = MaterialTheme.colorScheme.primary50,
                trackColor = MaterialTheme.colorScheme.neutralVariant95
            )
        }
    }
}

@Composable
fun TopBarNavigationIcon(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_back_arrow,
    onClick: () -> Unit
) {
    Box(modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
        IconButton(
            onClick = { onClick() }
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Back Arrow"
            )
        }
    }
}

@Composable
fun TopBarActionIcon(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_search,
    onClick: () -> Unit
) {
    Box(modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Localized description"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreviews() {
    PulseScoreTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
                .background(Color.White)

        ) {
            ProgressTopBar()
            Spacer(modifier = Modifier.height(50.dp))
            TitleTopBar()
            Spacer(modifier = Modifier.height(50.dp))
            TitleWithActionsTopBar()
        }
    }
}

