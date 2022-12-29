package net.denis.productioncontrol.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.denis.productioncontrol.presentation.screen.ChecklistScreen
import net.denis.productioncontrol.presentation.screen.StageScreen
import net.denis.productioncontrol.presentation.state.StageContract
import net.denis.productioncontrol.presentation.viewmodel.StageViewModel
import net.denis.productioncontrol.util.Constants.PARAM_STAGE_ID

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
            StageScreen(navController = navController, vm = vm)
        }

        composable(
            route = Screen.Checklist.route,
            arguments = listOf(
                navArgument(PARAM_STAGE_ID) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt(PARAM_STAGE_ID)
            if (id != null) {
                ChecklistScreen(stageId = id, vm = vm)
            }
        }
    }

}