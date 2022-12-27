package net.denis.productioncontrol.presentation.navigation

sealed class Screen(val route: String) {

    object Stage : Screen("Stage")

}