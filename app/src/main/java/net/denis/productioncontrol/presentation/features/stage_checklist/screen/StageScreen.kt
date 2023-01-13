package net.denis.productioncontrol.presentation.features.stage_checklist.screen

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
        stage = viewState.value.stageList,
        navController = navController,
    )
}

@Composable
private fun StageScreenList(
    modifier: Modifier = Modifier,
    showLoading: Boolean,
    stage: List<Stage>,
    navController: NavController,
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

    if (!showLoading) {
        CenteredProgressBar()
    }
}