package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import net.denis.productioncontrol.core.presentation.redux.Reducer

class StageReducer : Reducer<StageState, StageAction> {

    override fun reduce(currentState: StageState, action: StageAction): StageState {
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