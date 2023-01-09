package net.denis.productioncontrol.presentation.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.presentation.screen.components.ChecklistCardItem
import net.denis.productioncontrol.presentation.screen.stage_screen.viewmodel.StageContract
import net.denis.productioncontrol.presentation.screen.stage_screen.viewmodel.StageViewModel

@Composable
fun ChecklistScreen(
    vm: StageViewModel,
    stageId: Int,
) {
    val state = vm.viewState.value

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
    getChecklist(stageId = stageId,
        onClick = {
            vm.handleEvent(
                event = StageContract.Event.LoadNextChecklistItem(
                    currentChecklistId = it
                )
            )
        })

}

@Composable
fun getChecklist(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit,
    stageId: Int,
) {
    Column {
        ChecklistCardItem(
            onRadioClick = { radioItem ->
                when (radioItem) {
                    0 -> {
                        onClick(radioItem)
                        Log.d("----", "radioItem = 0")
                    }
                    1 -> {
                        onClick(radioItem)
                        Log.d("----", "radioItem = 1")
                    }
                    2 -> {
                        onClick(radioItem)
                        Log.d("----", "radioItem = $radioItem")
                    }
                }
            },
            text = stageId.toString(),
        )
    }
}

@Composable
fun testGet(
    state: StageContract.State,
    stageId: Int,
    onClick: (Int) -> Unit,
) {
    LazyColumn {
        items(state.stageList) { stage ->
            stage.checklist.forEach() { checklist ->
                if (stage.id == stageId && checklist.id == 0) {
                    Text(
                        text = checklist.name,
                        modifier = Modifier.clickable {
                            onClick(checklist.id)
                        }
                    )
                }
            }
        }
    }
}

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