package com.raerossi.pulsescore.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.raerossi.pulsescore.R


sealed class OnBoardingPage(
    @DrawableRes val imageResId: Int,
    @StringRes val titleResId:Int,
    @StringRes val descriptionResId:Int
) {
    object First : OnBoardingPage(
        imageResId = R.drawable.first_onboarding_image,
        titleResId = R.string.first_onboarding_title,
        descriptionResId = R.string.first_onboarding_body
    )
    object Second : OnBoardingPage(
        imageResId = R.drawable.second_onboarding_image,
        titleResId = R.string.second_onboarding_title,
        descriptionResId = R.string.second_onboarding_body
    )
    object Third : OnBoardingPage(
        imageResId = R.drawable.third_onboarding_image,
        titleResId = R.string.third_onboarding_title,
        descriptionResId = R.string.third_onboarding_body
    )
}
