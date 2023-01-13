package net.denis.productioncontrol.presentation.features.stage_checklist.mvi

import net.denis.productioncontrol.presentation.model.Stage
import net.denis.productioncontrol.presentation.redux.State

data class StageViewState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val stageList: List<Stage> = emptyList(),
) : State