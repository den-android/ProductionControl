package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage
import net.denis.productioncontrol.core.presentation.redux.State

data class StageViewState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val stageList: List<Stage> = emptyList(),
) : State