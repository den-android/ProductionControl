package net.denis.productioncontrol.presentation.features.common.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.presentation.features.stage_checklist.mvi.StageViewModel
import net.denis.productioncontrol.presentation.features.stage_checklist.screen.components.ChecklistCardItem
import net.denis.productioncontrol.presentation.model.Stage

@Composable
fun ChecklistScreen(
    vm: StageViewModel,
    stageId: Int,
) {
    val viewState = vm.viewState.collectAsState()
    val stage = viewState.value.stageList

    /**
     * КОСТЫЛЬ (исправить в первую же очередь)
     * Нужно подразобраться с Jetpack'ом
     * Один и тот же затык, что и в [ChecklistCardItem]
     */
    val currentChecklist = remember { mutableStateOf(0) }

    viewState.value.stageList.forEach { stage ->
        stage.checklist.forEach { checklist ->
            if (stage.id == stageId && checklist.id == currentChecklist.value) {
                ChecklistItem(
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
private fun ChecklistItem(
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