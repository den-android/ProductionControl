package net.denis.productioncontrol.features.stage_checklist.mvi

import net.denis.productioncontrol.features.stage_checklist.model.Stage
import net.denis.productioncontrol.core.presentation.redux.State
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem

data class StageState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val stageList: List<Stage> = emptyList(),
    val checklistItem: ChecklistItem? = null,
) : State