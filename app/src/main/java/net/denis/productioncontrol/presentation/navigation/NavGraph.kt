package net.denis.productioncontrol.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.denis.productioncontrol.presentation.screen.AssemblyStageScreen
import net.denis.productioncontrol.presentation.screen.ChecklistScreen

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AssemblyStageList.route
    ) {
        composable(
            route = Screen.AssemblyStageList.route
        ) {
            AssemblyStageScreen()
        }
        composable(
            route = Screen.Checklist.route
        ) {
            ChecklistScreen()
        }
    }

}