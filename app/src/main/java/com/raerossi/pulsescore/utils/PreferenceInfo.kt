package com.raerossi.pulsescore.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PreferenceInfo(
    @DrawableRes val imageResId: Int,
    @StringRes val name: Int,
    var isSelected: Boolean = false,
    var isSecondSelected: Boolean = false
)
/*
data class IconState(
    var selected: Boolean = false,
    var onSelectedChanged: (Boolean) -> Unit
)*/