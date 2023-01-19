package net.denis.productioncontrol.features.stage_checklist.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.features.stage_checklist.presentation.model.ChecklistItem
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage
import net.denis.productioncontrol.features.stage_checklist.presentation.mvi.StageViewModel
import net.denis.productioncontrol.features.stage_checklist.presentation.screen.components.ChecklistCardItem

@Composable
fun ChecklistScreen(
    vm: StageViewModel,
    stageId: Int,
) {
    val viewState = vm.viewState.collectAsState()
    val stage = viewState.value.stageList

    ChecklistItem(
        stage = stage,
        stageId = stageId,
        sendResult = vm::sendChecklistResults
    )

}

@Composable
private fun ChecklistItem(
    modifier: Modifier = Modifier,
    stage: List<Stage>,
    stageId: Int,
    sendResult: (ChecklistItem) -> Unit,
) {
    val showAlertDialog = rememberSaveable { mutableStateOf(false) }
    val currentChecklist = remember { mutableStateOf(0) }

    stage.forEach { stage ->
        stage.checklist.forEach { checklist ->
            if (stage.id == stageId && checklist.id == currentChecklist.value) {
                ChecklistCardItem(
                    checklist = checklist,
                    statusClick = { statusId ->
                        sendResult(
                            ChecklistItem(
                                checklistItemId = currentChecklist.value,
                                statusId = statusId,
                                stageId = stageId,
                                message = null,
                            )
                        )
                        currentChecklist.value += 1
                    },
                )
            }
        }

    }
}