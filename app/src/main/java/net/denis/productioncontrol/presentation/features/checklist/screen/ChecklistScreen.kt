package net.denis.productioncontrol.presentation.features.checklist.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.presentation.features.stage.mvi.StageViewModel
import net.denis.productioncontrol.presentation.model.Stage

@Composable
fun ChecklistScreen(
    vm: StageViewModel,
    stageId: Int,
) {
    val viewState = vm.viewState.collectAsState()
    val stage = viewState.value.stageList

    /***
     * Костыль (исправить в первую очередь)
     * надо узнать больше про Jetpack Composable чтобы починить
     */
    val currentChecklist = remember { mutableStateOf(0) }

    viewState.value.stageList.forEach { stage ->
        stage.checklist.forEach { checklist ->
            if (stage.id == stageId && checklist.id == currentChecklist.value) {
                ChecklistList(
                    stage = stage,
                    currentId = checklist.id,
                    statusClick = {
                        currentChecklist.value += 1
                        Log.d("Logging", "radioItem click: ${it}")
                    },
                )
            }
        }
    }


}

@Composable
private fun ChecklistList(
    modifier: Modifier = Modifier,
    stage: Stage,
    currentId: Int,
    statusClick: (Int) -> Unit,
) {
    ChecklistCardItem(
        checklist = stage.checklist[currentId],
        statusClick = { statusClick(it) },
    )
}


//@Composable
//private fun getChecklist(
//    modifier: Modifier = Modifier,
//    state: StageContract.State,
//    stageId: Int,
//) {
//    LazyColumn {
//        items(state.stageState.stageList) { stage ->
//            stage.checklist.forEach() { checklist ->
//                if (stage.id == stageId && checklist.id == 0) {
//                    ChecklistCardItem(
//                        modifier = modifier
//                            .fillMaxWidth()
//                            .fillParentMaxHeight(1f),
//                        text = checklist.name,
//                        statusClick = {
//                            when (it) {
//                                0 -> {
//
//                                }
//                                1 -> {
//
//                                }
//                                2 -> {
//
//                                }
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    }
//}


//    state.stageState.stageList.forEach { stage ->
//        stage.checklist.forEach { checklist ->
//            if (stageId == stage.id && checklist.id == click()) {
//                ChecklistCardItem(
//                    text = checklist.name,
//                    statusClick = {
//                        test(checklist.id, stage.checklist.size)
//                    }
//                )
//            }
//        }
//    }

//
//@Composable
//private fun getChecklist(
//    modifier: Modifier = Modifier,
//    state: StageContract.State,
//    stageId: Int,
//    checklistId: Int,
//    loadChecklist: (Int) -> Unit,
//) {
//    LazyColumn {
//        items(state.stageState.stageList) { stage ->
//            stage.checklist.forEach() { checklist ->
//                if (stage.id == stageId && checklist.id == checklistId) {
//                    ChecklistCardItem(
//                        modifier = modifier
//                            .fillMaxWidth()
//                            .fillParentMaxHeight(1f),
//                        text = checklist.name,
//                        statusClick = {
//                            when (it) {
//                                0 -> {
//                                    loadChecklist(it)
//                                    Log.d("----", "radioItem = $it")
//                                }
//                                1 -> {
//                                    loadChecklist(it)
//                                    Log.d("----", "radioItem = $it")
//                                }
//                                2 -> {
//                                    loadChecklist(it)
//                                    Log.d("----", "radioItem = $it")
//                                }
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun ChecklistCardItem2(
//    modifier: Modifier = Modifier,
//    text: String,
//) {
//    val checklistNameScroll = rememberScrollState(0)
//
//    Card(
//        modifier = modifier
//            .padding(4.dp),
//        shape = MaterialTheme.shapes.small,
//        elevation = 4.dp,
//    ) {
//        Column(
//            modifier = modifier
//                .padding(6.dp),
//        ) {
//
//            Box(
//                modifier = modifier
//                    .weight(1f)
//            ) {
//                Text(
//                    modifier = modifier
//                        .padding(bottom = 8.dp)
//                        .verticalScroll(checklistNameScroll),
//                    fontSize = 24.sp,
//                    overflow = TextOverflow.Clip,
//                    textAlign = TextAlign.Start,
//                    style = TextStyle(textIndent = TextIndent(20.sp)),
//                    text = text,
//                )
//            }
//            Box(
//                modifier = modifier
//                    .weight(2f)
//            ) {
//                CustomRadioGroup(onRadioClick = {
//
//                })
//            }
//
//        }
//
//    }
//}


//    testGet(
//        state = state,
//        stageId = stageId,
//        onClick = {
//            vm.handleEvent(
//                event = StageContract.Event.LoadNextChecklistItem(
//                    status = "1",
//                    stageIdEvent = stageId,
//                    currentChecklistId = it
//                )
//            )
//        }
//    )
//    getChecklist(stageId = stageId,
//        onClick = {
//            vm.handleEvent(
//                event = StageContract.Event.LoadNextChecklistItem(
//                    currentChecklistId = it
//                )
//            )
//        })
//
//}
//
//@Composable
//fun getChecklist(
//    modifier: Modifier = Modifier,
//    onClick: (Int) -> Unit,
//    stageId: Int,
//) {
//    Column {
//        ChecklistCardItem(
//            onRadioClick = { radioItem ->
//                when (radioItem) {
//                    0 -> {
//                        onClick(radioItem)
//                        Log.d("----", "radioItem = 0")
//                    }
//                    1 -> {
//                        onClick(radioItem)
//                        Log.d("----", "radioItem = 1")
//                    }
//                    2 -> {
//                        onClick(radioItem)
//                        Log.d("----", "radioItem = $radioItem")
//                    }
//                }
//            },
//            text = stageId.toString(),
//        )
//    }
//}
//
//@Composable
//fun testGet(
//    state: StageContract.State,
//    stageId: Int,
//    onClick: (Int) -> Unit,
//) {
//    LazyColumn {
//        items(state.stageList) { stage ->
//            stage.checklist.forEach() { checklist ->
//                if (stage.id == stageId && checklist.id == 0) {
//                    Text(
//                        text = checklist.name,
//                        modifier = Modifier.clickable {
//                            onClick(checklist.id)
//                        }
//                    )
//                }
//            }
//        }
//    }
//}

//  val checklist = Checklist(0, "Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text v")
//
//    ChecklistCardItem(
//        checklist = checklist,
//        loadNextChecklistItem = {
//        }
//    )
/*
    LazyColumn {
        items(state.stageList) { item ->
            item.checklist.forEach() { checklist ->
                ChecklistCardItem(
                    checklist = checklist,
                    modifier = modifier
                        .fillParentMaxHeight(1f)
                        .clickable {
                            loadNextChecklistItem
                        },
                )
            }


        }
    }
 */