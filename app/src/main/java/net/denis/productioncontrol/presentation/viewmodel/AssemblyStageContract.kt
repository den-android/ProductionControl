package net.denis.productioncontrol.presentation.viewmodel

import net.denis.productioncontrol.domain.model.AssemblyStage

class AssemblyStageContract {

    sealed class Event {
        object FetchAssemblyStage: Event()
        data class SaveAssemblyStage(val stage: AssemblyStage): Event()
    }

    data class State(
        val assemblyStageState: ViewState
    )

    sealed class ViewState {
        object Idle : ViewState()
        object Loading : ViewState()
        class Error(val message: String?) : ViewState()
        class Success(val stages: List<AssemblyStage>) : ViewState()
    }

}