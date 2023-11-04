package com.raerossi.pulsescore.views.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.R
import com.raerossi.pulsescore.composeutils.PrimaryButton
import com.raerossi.pulsescore.composeutils.TitleAndDescription
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.backgroundGradient


@Composable
fun WelcomeScreen() {
    Column(Modifier.background(backgroundGradient)) {
        WelcomeImage(Modifier.weight(1f))
        WelcomeTitleAndDescription()
        Spacer(modifier = Modifier.height(32.dp))
        ContinueButton()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun WelcomeImage(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.welcome_image),
        contentDescription = null
    )
}

@Composable
fun WelcomeTitleAndDescription(modifier: Modifier = Modifier) {
    TitleAndDescription(
        modifier = modifier,
        title = stringResource(id = R.string.welcome_title),
        description = stringResource(id = R.string.welcome_body),
        darkMode = true,
        centerAlign = true
    )
}

@Composable
fun ContinueButton(modifier: Modifier = Modifier) {
    PrimaryButton(
        modifier = modifier.padding(horizontal = 16.dp),
        text = "Continue",
        darkMode = true
    ) {

    }
}

@Preview(
    heightDp = 746,
    widthDp = 360,
    showBackground = true
)
@Composable
fun WelcomeScreenPreview() {
    PulseScoreTheme {
        WelcomeScreen()
    }
}