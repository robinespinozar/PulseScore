package com.raerossi.pulsescore.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class League(
    @DrawableRes val imageResId: Int,
    @StringRes val name: Int,
    val TeamList: List<Team>? = null
)