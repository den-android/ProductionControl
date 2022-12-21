package net.denis.productioncontrol.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.denis.productioncontrol.presentation.screen.AssemblyStageScreen
import net.denis.productioncontrol.presentation.screen.CarListScreen
import net.denis.productioncontrol.presentation.screen.ChecklistScreen
import net.denis.productioncontrol.presentation.viewmodel.CarViewModel


@Composable
fun NavGraph(
    navController: NavHostController,
    vm: CarViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CarList.route
    ) {
        composable(
            route = Screen.CarList.route
        ) {
            CarListScreen(vm = vm)

        }
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