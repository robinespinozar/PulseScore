package com.raerossi.pulsescore.views.preferences

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.R
import com.raerossi.pulsescore.composeutils.VerticalSpacer
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.utils.PreferenceInfo

@Composable
fun PreferenceItem(
    preferenceInfo: PreferenceInfo,
    height: Int = 72,
    thickness: Int = 1,
    isNotificationScreen: Boolean = false
) {
    Column(
        modifier = Modifier.height(height.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PreferenceContent(
            modifier = Modifier.height((height - thickness).dp),
            preferenceInfo = preferenceInfo,
            isNotificationScreen = isNotificationScreen
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0x38969696),
            thickness = thickness.dp
        )
    }
}
/*
@Composable
private fun PreferenceContent(
    modifier: Modifier = Modifier,
    @DrawableRes clubImage: Int,
    @StringRes clubName: Int
) {
    var isFavorite by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(start = 8.dp)
                .height(40.dp)
                .width(40.dp),
            painter = painterResource(id = clubImage),
            contentDescription = "image club"
        )
        Text(
            modifier = Modifier.padding(start = 18.dp),
            text = stringResource(id = clubName),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { isFavorite = !isFavorite }) {
            Icon(
                painter = if (isFavorite) painterResource(id = R.drawable.ic_star_filled) else painterResource(
                    id = R.drawable.ic_star
                ),
                contentDescription = "is favorite",
                tint = Color.Unspecified
            )
        }
    }
}*/

@Composable
private fun PreferenceContent(
    modifier: Modifier = Modifier,
    preferenceInfo: PreferenceInfo,
    isNotificationScreen: Boolean = false
) {
    var isFavorite by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(start = 8.dp)
                .height(40.dp)
                .width(40.dp),
            painter = painterResource(id = preferenceInfo.imageResId),
            contentDescription = "image club"
        )
        Text(
            modifier = Modifier.padding(start = 18.dp),
            text = stringResource(id = preferenceInfo.name),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isNotificationScreen) NotificationIcons(preferenceInfo) else FavoriteIcons(
            preferenceInfo
        )
    }
}


//No me parece correcto tener FavoriteIcons y NotificationIcos por separado
// Creo que no debería manejar esto por isNotificationScreen
@Composable
fun FavoriteIcons(preferenceInfo: PreferenceInfo) {
    var isFavorite by rememberSaveable { mutableStateOf(false) }

    IconButton(
        onClick = { isFavorite = !isFavorite }) {
        Icon(
            painter = if (isFavorite) painterResource(id = R.drawable.ic_star_filled) else painterResource(
                id = R.drawable.ic_star
            ),
            contentDescription = "is favorite",
            tint = Color.Unspecified
        )
    }
}

//Es mala practica , ya que he duplicado el codigo del IconButton, debo corregirlo
//Me parece que todo esto debería administrarlo con funciones lambdas
// Creo que debería ser adaptativo como el TopAppBar, al que le paso botones y funciona sin importar la cantidad que le pase
@Composable
fun NotificationIcons(preferenceInfo: PreferenceInfo) {
    var isMatchFavorite by rememberSaveable { mutableStateOf(false) }
    var isNewsFavorite by rememberSaveable { mutableStateOf(false) }

        IconButton(
            onClick = { isMatchFavorite = !isMatchFavorite }) {
            Icon(
                painter =
                if (isMatchFavorite) painterResource(id = R.drawable.ic_notification_filled)
                else painterResource(id = R.drawable.ic_notification),
                contentDescription = "is favorite",
                tint = Color.Unspecified
            )
        }
        IconButton(
            onClick = { isNewsFavorite = !isNewsFavorite }) {
            Icon(
                if (isNewsFavorite) painterResource(id = R.drawable.ic_notification_filled)
                else painterResource(id = R.drawable.ic_notification),
                contentDescription = "is favorite",
                tint = Color.Unspecified
            )
        }
}

@Preview(showBackground = true)
@Composable
fun TeamItemPreviews() {
    PulseScoreTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)

        ) {
            PreferenceItem(PreferenceInfo(R.drawable.liverpool, R.string.liverpool))
            VerticalSpacer(height = 32)
            PreferenceItem(
                PreferenceInfo(R.drawable.premier_league, R.string.premier_league),
                isNotificationScreen = true
            )
        }
    }
}