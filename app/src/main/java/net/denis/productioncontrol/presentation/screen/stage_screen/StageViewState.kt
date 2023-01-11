package net.denis.productioncontrol.presentation.screen.stage_screen

import net.denis.productioncontrol.presentation.model.Checklist
import net.denis.productioncontrol.presentation.model.Stage
import net.denis.productioncontrol.presentation.redux.State

data class StageViewState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val stageList: List<Stage> = emptyList(),

): State

sealed class StageState {
    object Loading : StageState()
    object Error: StageState()
    data class Content(
        val stageList: List<Stage>
    ):StageState()
}