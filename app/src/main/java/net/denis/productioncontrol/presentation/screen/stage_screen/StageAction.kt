package net.denis.productioncontrol.presentation.screen.stage_screen

import net.denis.productioncontrol.presentation.model.Checklist
import net.denis.productioncontrol.presentation.model.Stage
import net.denis.productioncontrol.presentation.redux.Action

sealed class StageAction : Action {

    object FetchStage : StageAction()
    data class StageDataLoaded(val stage: List<Stage>) : StageAction()

    data class LoadNextChecklist(
        val nextChecklistId: Int,
        //val checklist: List<Checklist>
    ) : StageAction()

}