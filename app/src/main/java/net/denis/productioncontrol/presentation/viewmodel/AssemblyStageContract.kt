package net.denis.productioncontrol.presentation.viewmodel

import net.denis.productioncontrol.domain.model.AssemblyStage

class AssemblyStageContract {

    sealed class Event {
        object FetchAssemblyStage: Event()
        data class OnStageClicked(val stage: AssemblyStage): Event()
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