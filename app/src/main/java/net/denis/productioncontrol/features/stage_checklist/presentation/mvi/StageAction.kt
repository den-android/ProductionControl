package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import net.denis.productioncontrol.core.presentation.redux.Action
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage

sealed class StageAction : Action {

    object StageLoading : StageAction()
    data class StageLoaded(val stage: List<Stage>) : StageAction()

    data class SendChecklistItems(
        val stageId: Int,
        val checklistItemId: Int,
        val statusCode: Int,
        val message: String?,
    ) : StageAction()

    object SendChecklistResult : StageAction()
}