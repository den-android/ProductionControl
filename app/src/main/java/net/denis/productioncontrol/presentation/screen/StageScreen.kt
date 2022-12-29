package net.denis.productioncontrol.presentation.screen

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collect
import net.denis.productioncontrol.domain.model.Stage
import net.denis.productioncontrol.presentation.navigation.Screen
import net.denis.productioncontrol.presentation.screen.components.StageCardItem
import net.denis.productioncontrol.presentation.state.StageContract
import net.denis.productioncontrol.presentation.viewmodel.StageViewModel

@Composable
fun StageScreen(
    navController: NavController,
    vm: StageViewModel,
) {
    val state = vm.viewState.value
    getStageList(state = state, navController = navController)
}

@Composable
fun getStageList(
    navController: NavController,
    state: StageContract.State,
    modifier: Modifier = Modifier,
) {
    LazyColumn{
        items(state.stageList){ stage ->
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

        item{
            if (state.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }

}
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
