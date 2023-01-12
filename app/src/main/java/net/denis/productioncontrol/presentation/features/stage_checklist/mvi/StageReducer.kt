package net.denis.productioncontrol.presentation.features.stage_checklist.mvi

import net.denis.productioncontrol.presentation.redux.Reducer

class StageReducer : Reducer<StageViewState, StageAction> {

    override fun reduce(currentState: StageViewState, action: StageAction): StageViewState {
        return when (action) {

            is StageAction.StageLoading -> {
                currentState.copy(
                    isLoading = true,
                )
            }

            is StageAction.StageLoaded -> {
                currentState.copy(
                    isLoading = false,
                    stageList = action.stage,
                )
            }

            else -> currentState
        }
    }

}