package net.denis.productioncontrol.presentation.features.stage.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.denis.productioncontrol.presentation.features.common.components.CenteredProgressBar
import net.denis.productioncontrol.presentation.features.stage.mvi.StageViewModel
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

//@Preview(showBackground = true)
//@Composable
//fun testShow() {
//    StageScreenItem(
//        stage = listOf<Stage>(
//            Stage(
//                id = 0,
//                name = "first",
//                checklist = listOf<Checklist>(
//                    Checklist(
//                        id = 0,
//                        name = "first checklist"
//                    )
//                )
//            ),
//            Stage(
//                id = 1,
//                name = "second",
//                checklist = listOf<Checklist>(
//                    Checklist(
//                        id = 0,
//                        name = "first checklist"
//                    )
//                )
//            )
//        )
//    )
//}


//
//@Composable
//private fun getStageList(
//    modifier: Modifier = Modifier,
//    navController: NavController,
//) {
//    LazyColumn {
//        items(state.stageState.stageList) { stage ->
//            StageCardItem(
//                modifier = modifier
//                    .fillMaxWidth()
//                    .fillParentMaxHeight(0.25f),
//                stage = stage,
//                onClick = {
//                    navController.navigate(
//                        route = Screen.Checklist.passStageId(
//                            id = stage.id
//                        )
//                    )
//                }
//            )
//        }
//
//        item {
//            if (state.stageState.isLoading) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(6.dp),
//                    horizontalArrangement = Arrangement.Center
//                ) {
//                    CircularProgressIndicator()
//                }
//            }
//        }
//    }
//
//}
// showButton(onEventSent = { vm.handleEvent(it)})

//@Composable
//fun Include(
//    vm: StageViewModel,
//    state: StageContract.State,
//    onEventSent: (event: StageContract.Event) -> Unit,
//    //onEventHandler: (StageContract.Event) -> Unit,
//) {
//    val state = vm.viewState.value
//
//}

//@Composable
//fun showButton(
//    onEventSent: (event: StageContract.Event) -> Unit,
//) {
//    Button(onClick = {
//        onEventSent.invoke(StageContract.Event.OnSaveStage)
//    }) {
//        Text(
//            text = "number.toString()",
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
//}

//    LazyColumn(
//        verticalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxSize(),
//    ) {
//        items(state.stageList) { stage ->
//            StageCardItem(stage = stage)
//        }
//
//    }


//    when (state) {
//        is ScreenContract.StageState.Idle -> {
//
//        }
//        is ScreenContract.StageState.Loading -> {
//            ProgressIndicator()
//        }
//        is ScreenContract.StageState.Success -> {
//            LazyColumn(modifier = Modifier.fillMaxSize()){
//                items(state.stages) { i ->
//                    CardItem(stage = i)
//                }
//            }
//        }
//    }
