package com.raerossi.pulsescore.views.preferences

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.raerossi.pulsescore.composeutils.FavoriteActions
import com.raerossi.pulsescore.composeutils.ProgressTopBar
import com.raerossi.pulsescore.composeutils.SearchBar
import com.raerossi.pulsescore.composeutils.TitleAndDescription
import com.raerossi.pulsescore.composeutils.VerticalSpacer
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.neutralVariant40
import com.raerossi.pulsescore.ui.theme.neutralVariant80
import com.raerossi.pulsescore.ui.theme.title
import com.raerossi.pulsescore.utils.League
import com.raerossi.pulsescore.utils.PreferenceInfo
import com.raerossi.pulsescore.utils.PreferencePage
import com.raerossi.pulsescore.utils.Team

/* TODO: Esto debe ser mejorado PreferenceScreen debería de recibir
*   cualquier tipo de List<T> y no debería convertirlo mediante un metodo
*   averiguar si se puede hacer mediante interfaces */

/* TODO: Falta mejorar mucho, La parte de como administrar bien los PreferenceItems
*   No me parece del todo correcto que isNotificationScreen administre los iconos de la Screen */
//Puede mejorarse, tal vez crear un atributo en la clase
//PreferencePage que me permita saber si debe de ir con 2 iconos o no

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreferenceScreen(
    preferencePage: PreferencePage,
    preferenceList: List<PreferenceInfo>
) {
    Scaffold(
        topBar = { ProgressTopBar(progress = preferencePage.progressIndicator) },
        bottomBar = { FavoriteActions() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PreferenceHeader(
                title = stringResource(id = preferencePage.titleResId),
                description = stringResource(id = preferencePage.descriptionResId),
            )
            //Este if también me parece que está mal
            //me parece que debería ir en el PreferenceHeader
            if (preferencePage == PreferencePage.Notifications) NotificationHeader()
            PreferenceList(
                preferenceList = preferenceList,
                isNotificationScreen = preferencePage == PreferencePage.Notifications
            )
        }
    }
}

@Composable
fun NotificationHeader(
    height: Int = 55,
    thickness: Int = 1,
) {
    Column(Modifier.height(height.dp).padding(horizontal = 16.dp)) {
        Row(
            Modifier.height((height - thickness).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = 24.dp),
                color = MaterialTheme.colorScheme.title,
                text = "Notification",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = "Match",
                color = MaterialTheme.colorScheme.neutralVariant80,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                modifier = Modifier.padding(end = 4.dp),
                text = "News",
                color = MaterialTheme.colorScheme.neutralVariant80,
                style = MaterialTheme.typography.titleSmall
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0x38969696),
            thickness = thickness.dp
        )
    }
}

@Composable
private fun PreferenceHeader(
    modifier: Modifier = Modifier,
    title: String,
    description: String
) {
    Column(modifier.padding(top = 16.dp, bottom = 24.dp)) {
        TitleAndDescription(
            title = title,
            description = description
        )
        VerticalSpacer(16)
        SportsList(sportsList = getSportsList())
        VerticalSpacer(24)
        SearchBar(Modifier.padding(horizontal = 16.dp))
    }
}

@Composable
private fun SportsList(modifier: Modifier = Modifier, sportsList: List<String>) {
    LazyRow(modifier.padding(horizontal = 16.dp)) {
        items(sportsList) { sport ->
            SportItem(sport)
        }
    }
}

@Composable
private fun PreferenceList(
    modifier: Modifier = Modifier,
    preferenceList: List<PreferenceInfo>,
    isNotificationScreen: Boolean
) {
    LazyColumn(modifier.padding(horizontal = 16.dp)) {
        items(preferenceList) { preference ->
            PreferenceItem(
                preferenceInfo = preference,
                isNotificationScreen = isNotificationScreen
            )
        }
    }
}

fun getSportsList() = listOf(
    "Fútbol", "Basket", "Tenis", "Volley", "Béisbol", "Cricket", "Esports"
)

fun getTeamList() = listOf(
    Team(imageResId = R.drawable.real_madrid, name = R.string.real_madrid),
    Team(imageResId = R.drawable.barcelona, name = R.string.barcelona),
    Team(imageResId = R.drawable.liverpool, name = R.string.liverpool),
    Team(imageResId = R.drawable.manchester_city, name = R.string.manchester_city),
    Team(imageResId = R.drawable.manchester_united, name = R.string.manchester_united),
    Team(imageResId = R.drawable.milan, name = R.string.milan),
    Team(imageResId = R.drawable.inter_milan, name = R.string.inter_milan),
    Team(imageResId = R.drawable.newcastle, name = R.string.newcastle),
    Team(imageResId = R.drawable.juventus, name = R.string.juventus),
    Team(imageResId = R.drawable.arsenal, name = R.string.arsenal)
)

fun getLeaguesList() = listOf(
    League(imageResId = R.drawable.premier_league, name = R.string.premier_league),
    League(imageResId = R.drawable.la_liga, name = R.string.la_liga),
    League(imageResId = R.drawable.bundesliga, name = R.string.bundesliga),
    League(imageResId = R.drawable.serie_a, name = R.string.serie_a),
    League(imageResId = R.drawable.ligue_one, name = R.string.ligue_one)
)

//Creo que no debo hacer este convert
//El PreferenceScreen debería aceptar cualquier tipo de lista (Averiguar Interfaces)
//ver bien como usaré la clase PreferenceInfo
@Composable
fun convertTeamToPreference(list: List<Team>) =
    list.map { team ->
        var statusOne by rememberSaveable { mutableStateOf(false) }
        var statusTwo by rememberSaveable { mutableStateOf(false) }

        PreferenceInfo(
            imageResId = team.imageResId,
            name = team.name,
            isSelected = statusOne,
            isSecondSelected = statusTwo
        )
    }

@Composable
fun convertLeagueToPreference(
    list: List<League>
) = list.map { league ->
    var status by rememberSaveable { mutableStateOf(false) }

    PreferenceInfo(
        imageResId = league.imageResId,
        name = league.name,
        isSelected = status
    )
}

@Preview(showBackground = true, heightDp = 750, widthDp = 360)
@Composable
fun FavoriteScreenPreview() {
    PulseScoreTheme {
        PreferenceScreen(
            preferencePage = PreferencePage.Favorites,
            preferenceList = convertTeamToPreference(list = getTeamList())
        )
    }
}

@Preview(showBackground = true, heightDp = 750, widthDp = 360)
@Composable
fun NotificationScreenPreview() {
    PulseScoreTheme {
        PreferenceScreen(
            preferencePage = PreferencePage.Notifications,
            preferenceList = convertTeamToPreference(list = getTeamList())
        )
    }
}

@Preview(showBackground = true, heightDp = 750, widthDp = 360)
@Composable
fun CompetitionScreenPreview() {
    PulseScoreTheme {
        PreferenceScreen(
            preferencePage = PreferencePage.Competitions,
            preferenceList = convertLeagueToPreference(list = getLeaguesList())
        )
    }
}