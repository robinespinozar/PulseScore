package com.raerossi.pulsescore.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raerossi.pulsescore.ui.features.home.HomeScreen
import com.raerossi.pulsescore.ui.features.onboarding.OnBoardingViewModel
import com.raerossi.pulsescore.utils.PreferenceScreen
import com.raerossi.pulsescore.views.login.LoginScreen
import com.raerossi.pulsescore.views.onboarding.OnBoardingScreen
import com.raerossi.pulsescore.views.preferences.PreferenceScreen
import com.raerossi.pulsescore.views.preferences.convertLeagueToPreference
import com.raerossi.pulsescore.views.preferences.convertTeamToPreference
import com.raerossi.pulsescore.views.preferences.getLeaguesList
import com.raerossi.pulsescore.views.preferences.getTeamList
import com.raerossi.pulsescore.views.welcome.WelcomeScreen

@Composable
fun SetUpNavHost(
    navigationController: NavHostController,
    startDestination: String,
    context: Context
) {
    NavHost(
        navController = navigationController,
        startDestination = startDestination
    ) {
        composable(Routes.LoginScreen.route) {
            LoginScreen(navController = navigationController)
        }
        composable(Routes.OnBoardingScreen.route) {
            val onBoardingViewModel = OnBoardingViewModel(context)
            OnBoardingScreen(navController = navigationController,onBoardingViewModel = onBoardingViewModel)
        }
        composable(Routes.HomeScreen.route) {
            HomeScreen()
        }
        composable(Routes.WelcomeScreen.route) {
            WelcomeScreen(navController = navigationController)
        }
        composable(Routes.PreferencesTeamsScreen.route) {
            PreferenceScreen(
                navController = navigationController,
                preferenceScreen = PreferenceScreen.Teams,// La lista de equipos no debería pasarla, automaticamente con Teams debería identificar que hacer
                preferenceList = convertTeamToPreference(list = getTeamList())
            )
        }
        composable(Routes.PreferencesNotificationsScreen.route) {
            PreferenceScreen(
                navController = navigationController,
                preferenceScreen = PreferenceScreen.Notifications,// La lista de equipos no debería pasarla, automaticamente con Notifications debería identificar que hacer
                preferenceList = convertTeamToPreference(list = getTeamList())
            )
        }
        composable(Routes.PreferencesCompetitionsScreen.route) {
            PreferenceScreen(
                navController = navigationController,
                preferenceScreen = PreferenceScreen.Competitions, // La lista de ligas no debería pasarla, automaticamente con Competitions debería identificar que hacer
                preferenceList = convertLeagueToPreference(list = getLeaguesList())
            )
        }
    }
}