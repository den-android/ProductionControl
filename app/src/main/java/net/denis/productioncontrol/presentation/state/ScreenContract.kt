package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.Stage
import net.denis.productioncontrol.presentation.base.UiEffect
import net.denis.productioncontrol.presentation.base.UiEvent
import net.denis.productioncontrol.presentation.base.UiState

class ScreenContract {

    sealed class Event: UiEvent {
        object OnFetchPosts: Event()
    }

    data class State(
        val stageState: StageState
    ): UiState

    sealed class StageState {
        object Idle: StageState()
        object Loading: StageState()
        data class Success(val stages: List<Stage>) : StageState()
    }

    sealed class Effect: UiEffect {
        data class ShowError(val message: String?): Effect()
    }
}