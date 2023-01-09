package net.denis.productioncontrol.presentation.screen.stage_screen.viewmodel

import net.denis.productioncontrol.domain.model.Stage
import net.denis.productioncontrol.presentation.base.ViewEvent
import net.denis.productioncontrol.presentation.base.ViewState

class StageContract {

    sealed class Event : ViewEvent {
        object OnFetchStage : Event()
        data class LoadNextChecklistItem(val currentChecklistId: Int) : Event()
    }

    data class State(
        val isLoading: Boolean = false,
        val error: String? = null,
        val stageList: List<Stage> = emptyList()
    ): ViewState

}