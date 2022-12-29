package net.denis.productioncontrol.presentation.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import net.denis.productioncontrol.data.remote.dto.StageDto
import net.denis.productioncontrol.domain.model.Checklist
import net.denis.productioncontrol.presentation.navigation.Screen
import net.denis.productioncontrol.presentation.screen.components.ChecklistCardItem
import net.denis.productioncontrol.presentation.screen.components.CustomAlertDialog
import net.denis.productioncontrol.presentation.screen.components.StageCardItem
import net.denis.productioncontrol.presentation.state.StageContract
import net.denis.productioncontrol.presentation.viewmodel.StageViewModel

@Composable
fun ChecklistScreen(
    vm: StageViewModel,
    stageId: Int,
) {
    val state = vm.viewState.value

    getChecklist(
        state = state,
        loadNextItem = {
            vm.handleEvent(
                event = StageContract.Event.LoadNextChecklistItem(
                    status = it,
                    stageIdEvent = stageId,
                )
            )
        },
        stageId = stageId
    )
}

@Composable
fun getChecklist(
    state: StageContract.State,
    modifier: Modifier = Modifier,
    loadNextItem: (String) -> Unit,
    stageId: Int,
) {
    val state = state.stageList
    Column {
        ChecklistCardItem(
            onRadioClick = {
                when (it) {
                    Color.Green -> {
                        loadNextItem("Green")
                    }
                    Color.Yellow -> {
                        loadNextItem("Yellow")
                    }
                    Color.Red -> {
                        loadNextItem("Red")
                    }
                }
            },
            checklistItemName = stageId.toString()
        )


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