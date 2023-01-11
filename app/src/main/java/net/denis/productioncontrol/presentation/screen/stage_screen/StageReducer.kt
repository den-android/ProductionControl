package net.denis.productioncontrol.presentation.screen.stage_screen

import net.denis.productioncontrol.presentation.redux.Action
import net.denis.productioncontrol.presentation.redux.Reducer
import net.denis.productioncontrol.presentation.redux.State

class StageReducer : Reducer<StageViewState, StageAction> {

    override fun reduce(currentState: StageViewState, action: StageAction): StageViewState {
        return when (action) {

            is StageAction.FetchStage -> {
                currentState.copy(
                    isLoading = true,
                )
            }

            is StageAction.StageDataLoaded -> {
                currentState.copy(
                    isLoading = false,
                    stageList = action.stage,
                )
            }


            else -> currentState
        }
    }

}