package net.denis.productioncontrol.features.stage_checklist.presentation.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.features.stage_checklist.presentation.model.CompletedChecklistItem
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage
import net.denis.productioncontrol.features.stage_checklist.presentation.mvi.StageViewModel
import net.denis.productioncontrol.features.stage_checklist.presentation.screen.components.ChecklistCardItem
import net.denis.productioncontrol.features.stage_checklist.presentation.screen.components.CustomAlertDialog

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
        sendResult = {
            vm.sendChecklistResults(rawChecklistItem = it)
        },
    )
}

@Composable
private fun ChecklistItem(
    modifier: Modifier = Modifier,
    stage: List<Stage>,
    stageId: Int,
    sendResult: (CompletedChecklistItem) -> Unit,
) {
    val showAlertDialog = rememberSaveable { mutableStateOf(false) }
    val currentChecklist = rememberSaveable { mutableStateOf(0) }

    stage.forEach { stage ->
        stage.checklist.forEach { checklist ->
            if (stage.id == stageId && checklist.id == currentChecklist.value) {
                ChecklistCardItem(
                    checklist = checklist,
                    statusClick = { statusId ->
                        showAlertDialog.value = true
                        sendResult(
                            CompletedChecklistItem(
                                stageId,
                                currentChecklist.value,
                                statusId,
                                "",
                            )
                        )

                    }
                )
            }
        }

        if (showAlertDialog.value) {
            CustomAlertDialog(
                onDialogDismissClick = {
                    showAlertDialog.value = false
                },
                onDialogOkClick = {
                    showAlertDialog.value = false
                    currentChecklist.value += 1
                }
            )
        }
    }
}