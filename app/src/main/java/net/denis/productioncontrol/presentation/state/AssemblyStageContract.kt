package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.domain.model.Checklist

class AssemblyStageContract {

    sealed class Event {
        object FetchAssemblyStage: Event()
        object FetchChecklist: Event()
        data class OnStageClicked(val stage: AssemblyStage): Event()
        data class OnChecklistClicked(val checklistClicked: Checklist): Event()
    }

    data class State(
        val assemblyStageState: AssemblyStageState
    )

    sealed class AssemblyStageState {
        object Idle : AssemblyStageState()
        object Loading : AssemblyStageState()
        class Error(val message: String?) : AssemblyStageState()
        class Success(val stages: List<AssemblyStage>) : AssemblyStageState()
    }

}