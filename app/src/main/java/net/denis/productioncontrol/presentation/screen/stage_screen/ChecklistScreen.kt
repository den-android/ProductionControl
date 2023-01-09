package net.denis.productioncontrol.presentation.screen.stage_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.denis.productioncontrol.presentation.screen.stage_screen.components.ChecklistCardItem
import net.denis.productioncontrol.presentation.screen.stage_screen.components.CustomRadioGroup
import net.denis.productioncontrol.presentation.screen.stage_screen.viewmodel.StageContract
import net.denis.productioncontrol.presentation.screen.stage_screen.viewmodel.StageViewModel

@Composable
fun ChecklistScreen(
    vm: StageViewModel,
    stageId: Int,
) {
    getChecklist(
        stageId = stageId,
        state = vm.viewState.value,
    )

}

@Composable
private fun getChecklist(
    modifier: Modifier = Modifier,
    state: StageContract.State,
    stageId: Int,
) {
    LazyColumn {
        items(state.stageState.stageList) { stage ->
            stage.checklist.forEach() { checklist ->
                if (stage.id == stageId) {
                    ChecklistCardItem(
                        modifier = modifier
                            .fillMaxWidth()
                            .fillParentMaxHeight(1f),
                        text = checklist.name,
                    )
                }
            }
        }
    }
}
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