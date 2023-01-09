package net.denis.productioncontrol.presentation.screen.stage_screen.viewmodel

import net.denis.productioncontrol.presentation.base.ViewEvent
import net.denis.productioncontrol.presentation.base.ViewState
import net.denis.productioncontrol.presentation.screen.stage_screen.state.StageState

class StageContract {

    sealed class Event : ViewEvent {
        object FetchStage : Event()
        object FetchChecklist : Event()
        //object LoadNextItem : Event()
        data class LoadNextItem(val currentChecklistId: Int) : Event()
    }

    data class State(
        val stageState: StageState,
    ) : ViewState

}