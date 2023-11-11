package com.raerossi.pulsescore.ui.navigation

sealed class Routes(
    val route : String
) {
    object LoginScreen: Routes(route = "login_screen")
    object OnBoardingScreen: Routes(route = "onboarding_screen")
    object WelcomeScreen: Routes(route = "welcome_screen")
    object PreferencesTeamsScreen: Routes(route = "preferences_teams_screen")
    object PreferencesNotificationsScreen: Routes(route = "preferences_notifications_screen")
    object PreferencesCompetitionsScreen: Routes(route = "preferences_competitions_screen")
}