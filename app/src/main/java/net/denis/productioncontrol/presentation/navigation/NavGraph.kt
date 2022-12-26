package net.denis.productioncontrol.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.denis.productioncontrol.presentation.screen.AssemblyStageScreen
import net.denis.productioncontrol.presentation.viewmodel.AssemblyStageViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    vm: AssemblyStageViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AssemblyStage.route
    ) {
        composable(
            route = Screen.AssemblyStage.route
        ) {
            AssemblyStageScreen(viewModel = vm)
        }
    }

}