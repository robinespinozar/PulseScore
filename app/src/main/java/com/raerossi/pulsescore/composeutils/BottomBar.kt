package com.raerossi.pulsescore.composeutils

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.primary30
import com.raerossi.pulsescore.ui.theme.primary50
import com.raerossi.pulsescore.utils.BottomBarItem


@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    val barItems = listOf(
        BottomBarItem.Home,
        BottomBarItem.Matches,
        BottomBarItem.News,
        BottomBarItem.Profile
    )
    var selectedBarItem by remember { mutableStateOf(barItems.first()) }

    BottomNavigation(
        modifier
            .height(74.dp)
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
        contentColor = Color(0xFF9CA2AA),
        backgroundColor = Color(0xFFFAFAFA)
    ) {
        barItems.forEach { barItem ->
            BottomNavigationItem(
                modifier = Modifier.padding(bottom = 2.dp),
                icon = {
                    NavItemIcon(
                        isSelected = barItem == selectedBarItem,
                        selectedIcon = barItem.selectedIcon,
                        unselectedIcon = barItem.unselectedIcon
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                },
                label = {
                    NavItemLabel(
                        isSelected = barItem == selectedBarItem,
                        labelResId = barItem.labelResId
                    )
                },
                selected = (barItem == selectedBarItem),
                onClick = { selectedBarItem = barItem }
            )
        }
    }
}

@Composable
fun NavItemIcon(
    isSelected: Boolean,
    @DrawableRes selectedIcon: Int,
    @DrawableRes unselectedIcon: Int
) =
    Icon(
        painter = if (isSelected) painterResource(id = selectedIcon) else painterResource(id = unselectedIcon),
        contentDescription = null,
        tint = if (isSelected) MaterialTheme.colorScheme.primary50 else Color(0xFF9CA2AA)
    )

@Composable
fun NavItemLabel(
    isSelected: Boolean,
    @StringRes labelResId: Int
) =
    Text(
        text = stringResource(id = labelResId),
        color = if (isSelected) MaterialTheme.colorScheme.primary30 else Color(0xFF6B7280),
        style = MaterialTheme.typography.labelSmall
    )

@Preview(showBackground = true)
@Composable
fun BottomBarPreviews() {
    PulseScoreTheme {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
            BottomBar(Modifier.align(Alignment.BottomCenter))
        }
    }
}
