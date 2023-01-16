package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage
import net.denis.productioncontrol.core.presentation.redux.Action

sealed class StageAction : Action {

    object StageLoading : StageAction()
    data class StageLoaded(val stage: List<Stage>) : StageAction()

    data class ChecklistLoading(val currentId: Int) : StageAction()
}