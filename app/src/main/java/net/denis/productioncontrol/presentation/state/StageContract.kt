package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.Checklist
import net.denis.productioncontrol.domain.model.Stage
import net.denis.productioncontrol.presentation.base.ViewSideEffect
import net.denis.productioncontrol.presentation.base.ViewEvent
import net.denis.productioncontrol.presentation.base.ViewState

class StageContract {

    sealed class Event: ViewEvent {
        object OnFetchStage: Event()
        data class OnFetchChecklist(val idStage: Int): Event()
        object LoadNextChecklistItem: Event()
    }

    data class State(
        val isLoading: Boolean = false,
        val error: String? = null,
        val stageList: List<Stage> = emptyList()
    ): ViewState

    sealed class Effect: ViewSideEffect {
        data class ShowError(val message: String?): Effect()
    }
}