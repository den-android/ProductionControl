package net.denis.productioncontrol.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.denis.productioncontrol.presentation.screen.CarListScreen
import net.denis.productioncontrol.presentation.screen.ChecklistScreen
import net.denis.productioncontrol.presentation.screen.ProductionProcessScreen
import net.denis.productioncontrol.presentation.viewmodel.CarListViewModel


@Composable
fun NavGraph(
    navController: NavHostController,
    vm: CarListViewModel
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
            route = Screen.ProductionProcess.route
        ) {
            ProductionProcessScreen()
        }
        composable(
            route = Screen.Checklist.route
        ) {
            ChecklistScreen()
        }
    }

}