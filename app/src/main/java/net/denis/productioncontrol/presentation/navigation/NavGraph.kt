package net.denis.productioncontrol.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.denis.productioncontrol.presentation.screen.StageScreen
import net.denis.productioncontrol.presentation.state.StageContract
import net.denis.productioncontrol.presentation.viewmodel.StageViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    vm: StageViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Stage.route
    ) {
        composable(
            route = Screen.Stage.route
        ) {
            StageScreen(
                vm = vm
            )
        }
    }

}