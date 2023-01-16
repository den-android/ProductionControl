package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import net.denis.productioncontrol.core.presentation.redux.Reducer

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

            is StageAction.ChecklistLoading -> {
                currentState.copy(
                    isLoading = true
                )
            }

            else -> currentState
        }
    }

}