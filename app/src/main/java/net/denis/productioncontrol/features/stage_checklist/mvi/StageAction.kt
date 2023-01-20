package net.denis.productioncontrol.features.stage_checklist.mvi

import net.denis.productioncontrol.core.presentation.redux.Action
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem
import net.denis.productioncontrol.features.stage_checklist.model.Stage

sealed class StageAction : Action {

    object StageLoading : StageAction()
    data class StageLoaded(val stage: List<Stage>) : StageAction()


    data class FillChecklistItem(val checklistItem: ChecklistItem) : StageAction()
}