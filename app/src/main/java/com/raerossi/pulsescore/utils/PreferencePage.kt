package com.raerossi.pulsescore.utils

import androidx.annotation.StringRes
import com.raerossi.pulsescore.R

sealed class PreferenceScreen(
    val progressIndicator: Float,
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int,
) {
    object Teams: PreferenceScreen(
        progressIndicator = 0.4f,
        titleResId = R.string.favorites_title,
        descriptionResId = R.string.favorites_description
    )
    object Notifications: PreferenceScreen(
        progressIndicator = 0.62f,
        titleResId = R.string.notifications_title,
        descriptionResId = R.string.notifications_description
    )
    object Competitions: PreferenceScreen(
        progressIndicator = 0.82f,
        titleResId = R.string.competitions_title,
        descriptionResId = R.string.competitions_description
    )
}