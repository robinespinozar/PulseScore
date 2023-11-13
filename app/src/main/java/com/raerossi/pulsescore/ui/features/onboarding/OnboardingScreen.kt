package com.raerossi.pulsescore.views.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.raerossi.pulsescore.composeutils.PageIndicator
import com.raerossi.pulsescore.composeutils.PrimaryButton
import com.raerossi.pulsescore.composeutils.TitleAndDescription
import com.raerossi.pulsescore.composeutils.VerticalSpacer
import com.raerossi.pulsescore.ui.features.onboarding.OnBoardingViewModel
import com.raerossi.pulsescore.ui.navigation.Routes
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.neutral95
import com.raerossi.pulsescore.ui.theme.neutralVariant90
import com.raerossi.pulsescore.ui.theme.neutralVariant95
import com.raerossi.pulsescore.ui.theme.primary50
import com.raerossi.pulsescore.utils.OnBoardingPage

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            verticalAlignment = Alignment.CenterVertically,
            count = 3,
            state = pagerState
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        PageIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            numberOfPages = pages.size,
            selectedColor = MaterialTheme.colorScheme.primary50,
            inactiveColor =  MaterialTheme.colorScheme.neutralVariant90,
            selectedPage = pagerState.currentPage
        )
        FinishButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState
        )
        {
            onBoardingViewModel.saveOnBoardingState(completed = true)
            navController.popBackStack()
            navController.navigate(Routes.HomeScreen.route)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Column {
                PrimaryButton(text = "Start Now") { onClick() }
            }
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        PagerImage(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.7f),
            image = onBoardingPage.imageResId
        )
        VerticalSpacer(20)
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

@Preview(showBackground = true)
@Composable
fun FirstOnboardingScreenPreview() {
    PulseScoreTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            PagerScreen(onBoardingPage = OnBoardingPage.First)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondOnboardingScreenPreview() {
    PulseScoreTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            PagerScreen(onBoardingPage = OnBoardingPage.Second)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdOnboardingScreenPreview() {
    PulseScoreTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            PagerScreen(onBoardingPage = OnBoardingPage.Third)
        }
    }
}