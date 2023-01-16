package net.denis.productioncontrol.features.stage_checklist.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.features.stage_checklist.presentation.mvi.StageViewModel
import net.denis.productioncontrol.features.stage_checklist.presentation.screen.components.ChecklistCardItem
import net.denis.productioncontrol.features.stage_checklist.presentation.screen.components.CustomAlertDialog
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage

@Composable
fun ChecklistScreen(
    vm: StageViewModel,
    stageId: Int,
) {
    val viewState = vm.viewState.collectAsState()
    val stage = viewState.value.stageList

    val currentChecklist = rememberSaveable { mutableStateOf(0) }

    viewState.value.stageList.forEach { stage ->
        stage.checklist.forEach { checklist ->
            if (stage.id == stageId && checklist.id == currentChecklist.value) {
                ChecklistItem(
                    stage = stage,
                    currentId = checklist.id,
                    statusClick = {
                        /**
                         * status code viewed checklist
                         */
                    },
                    sendResult = {
                        vm.loadNextChecklist(currentChecklist.value)
                        currentChecklist.value += 1
                    }
                )
            }
        }
    }
}

@Composable
private fun ChecklistItem(
    modifier: Modifier = Modifier,
    stage: Stage,
    currentId: Int,
    statusClick: (Int) -> Unit,
    sendResult: () -> Unit,
) {
    val showAlertDialog = remember { mutableStateOf(false) }

    if (showAlertDialog.value) {
        CustomAlertDialog(
            onDialogDismissClick = {
                showAlertDialog.value = false
            },
            onDialogOkClick = {
                showAlertDialog.value = false
                sendResult()
            }
        )
    }
    ChecklistCardItem(
        checklist = stage.checklist[currentId],
        statusClick = {
            statusClick(it)
            showAlertDialog.value = true
        },
    )
}