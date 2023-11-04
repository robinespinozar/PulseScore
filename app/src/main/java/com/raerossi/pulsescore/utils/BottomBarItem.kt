package com.raerossi.pulsescore.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.raerossi.pulsescore.R

sealed class BottomBarItem(
    val route: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val labelResId: Int
) {
    object Home: BottomBarItem(
        route = "home",
        selectedIcon = R.drawable.ic_home_filled,
        unselectedIcon = R.drawable.ic_home,
        labelResId= R.string.home
    )
    object Matches: BottomBarItem(
        route = "matches",
        selectedIcon = R.drawable.ic_matches_filled,
        unselectedIcon = R.drawable.ic_matches,
        labelResId= R.string.matches
    )
    object News: BottomBarItem(
        route = "news",
        selectedIcon = R.drawable.ic_news_filled,
        unselectedIcon = R.drawable.ic_news,
        labelResId= R.string.news
    )
    object Profile: BottomBarItem(
        route = "profile",
        selectedIcon = R.drawable.ic_profile_filled,
        unselectedIcon = R.drawable.ic_profile,
        labelResId= R.string.profile
    )
}