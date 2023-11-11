package com.raerossi.pulsescore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raerossi.pulsescore.utils.PreferencePage
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
    startDestination: String
) {
    NavHost(
        navController = navigationController,
        startDestination = startDestination
    ) {
        composable(Routes.LoginScreen.route) {
            LoginScreen(navController = navigationController)
        }
        composable(Routes.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navigationController)
        }
        composable(Routes.WelcomeScreen.route) {
            WelcomeScreen(navController = navigationController)
        }
        composable(Routes.PreferencesTeamsScreen.route) {
            PreferenceScreen(
                navController = navigationController,
                preferencePage = PreferencePage.Teams,// La lista de equipos no debería pasarla, automaticamente con Teams debería identificar que hacer
                preferenceList = convertTeamToPreference(list = getTeamList())
            )
        }
        composable(Routes.PreferencesNotificationsScreen.route) {
            PreferenceScreen(
                navController = navigationController,
                preferencePage = PreferencePage.Notifications,// La lista de equipos no debería pasarla, automaticamente con Notifications debería identificar que hacer
                preferenceList = convertTeamToPreference(list = getTeamList())
            )
        }
        composable(Routes.PreferencesCompetitionsScreen.route) {
            PreferenceScreen(
                navController = navigationController,
                preferencePage = PreferencePage.Competitions, // La lista de ligas no debería pasarla, automaticamente con Competitions debería identificar que hacer
                preferenceList = convertLeagueToPreference(list = getLeaguesList())
            )
        }
    }
}