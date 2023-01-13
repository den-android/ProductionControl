package net.denis.productioncontrol.presentation.features.stage_checklist.mvi

import net.denis.productioncontrol.presentation.model.Stage
import net.denis.productioncontrol.presentation.redux.Action

sealed class StageAction : Action {

    object StageLoading : StageAction()
    data class StageLoaded(val stage: List<Stage>) : StageAction()

    data class ChecklistLoading(val currentId: Int) : StageAction()
}