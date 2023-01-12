package net.denis.productioncontrol.presentation.features.stage_checklist.mvi

import net.denis.productioncontrol.presentation.model.Checklist
import net.denis.productioncontrol.presentation.model.Stage
import net.denis.productioncontrol.presentation.redux.Action

sealed class StageAction : Action {

    object StageLoading : StageAction()
    data class StageLoaded(val stage: List<Stage>) : StageAction()

    object TestActionLoading: StageAction()
    data class TestActionCompleted(
        val stage: List<Stage>
    ): StageAction()

    data class LoadingNextChecklist3(val currentId: Int) : StageAction()
    object ChecklistLoading: StageAction()
    data class LoadingNextChecklist1(val checklist: Checklist) : StageAction()
    data class LoadingNextChecklist2(val stage: List<Stage>) : StageAction()
}