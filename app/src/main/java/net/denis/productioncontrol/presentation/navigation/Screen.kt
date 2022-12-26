package net.denis.productioncontrol.presentation.navigation

sealed class Screen(val route: String) {

    object AssemblyStage : Screen("AssemblyStage")

}