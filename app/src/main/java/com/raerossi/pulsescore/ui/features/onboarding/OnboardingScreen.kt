package com.raerossi.pulsescore.views.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.raerossi.pulsescore.composeutils.TitleAndDescription
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.utils.OnBoardingPage

@Composable
fun OnBoardingScreen(navController: NavHostController){

}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        PagerImage(
            modifier = Modifier.fillMaxWidth(1f)
                .fillMaxHeight(0.7f),
            image = onBoardingPage.imageResId
        )
        PagerTitleAndDescription(
            titleResId = onBoardingPage.titleResId,
            descriptionResId = onBoardingPage.descriptionResId
        )
    }
}

@Composable
fun PagerImage(modifier: Modifier = Modifier, image: Int) {
    Image(
        modifier = modifier
            .fillMaxWidth(),
        painter = painterResource(id = image),
        contentDescription = "Pager Image"
    )
}

@Composable
fun PagerTitleAndDescription(
    modifier: Modifier = Modifier,
    titleResId: Int,
    descriptionResId: Int
) {
    TitleAndDescription(
        modifier = modifier,
        title = stringResource(id = titleResId),
        description = stringResource(id = descriptionResId),
        centerAlign = true
    )
}

@Preview(
    heightDp = 746,
    widthDp = 360,
    showBackground = true
)
@Composable
fun FirstOnboardingScreenPreview() {
    PulseScoreTheme {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}

@Preview(
    heightDp = 746,
    widthDp = 360,
    showBackground = true
)
@Composable
fun SecondOnboardingScreenPreview() {
    PulseScoreTheme {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}

@Preview(
    heightDp = 746,
    widthDp = 360,
    showBackground = true
)
@Composable
fun ThirdOnboardingScreenPreview() {
    PulseScoreTheme {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}