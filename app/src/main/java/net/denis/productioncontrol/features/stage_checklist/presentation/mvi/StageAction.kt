package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import net.denis.productioncontrol.core.presentation.redux.Action
import net.denis.productioncontrol.features.stage_checklist.presentation.model.CompletedChecklistItem
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage

sealed class StageAction : Action {

    object StageLoading : StageAction()
    data class StageLoaded(val stage: List<Stage>) : StageAction()

    data class SendChecklistItems(val completedChecklistItem: CompletedChecklistItem) : StageAction()

    object SendChecklistResult : StageAction()
}