package net.denis.productioncontrol.presentation.features.stage_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.denis.productioncontrol.presentation.features.stage_checklist.mvi.StageViewModel
import net.denis.productioncontrol.presentation.features.stage_checklist.screen.components.CenteredProgressBar
import net.denis.productioncontrol.presentation.features.stage_checklist.screen.components.StageCardItem
import net.denis.productioncontrol.presentation.model.Stage
import net.denis.productioncontrol.presentation.navigation.Screen

@Composable
fun StageScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: StageViewModel,
) {
    val viewState = vm.viewState.collectAsState()
    StageScreenList(
        showLoading = viewState.value.isLoading,
        data = viewState.value.stageList,
        navController = navController,
    )
}

@Composable
private fun StageScreenList(
    modifier: Modifier = Modifier,
    showLoading: Boolean,
    data: List<Stage>,
    navController: NavController,
) {
    if (data != null) {
        StageScreenItem(navController = navController, stage = data)
    }

    if (!showLoading) {
        CenteredProgressBar()
    }
}

@Composable
private fun StageScreenItem(
    modifier: Modifier = Modifier,
    navController: NavController,
    stage: List<Stage>,
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
    ) {

        items(stage) { stage ->
            StageCardItem(
                modifier = modifier
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.25f),
                stage = stage,
                onClick = {
                    navController.navigate(
                        route = Screen.Checklist.passStageId(
                            id = stage.id
                        )
                    )
                }
            )
        }

    }

}