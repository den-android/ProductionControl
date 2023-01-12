package net.denis.productioncontrol.presentation.features.stage_checklist.mvi

import android.util.Log
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

            is StageAction.TestActionLoading -> {
                currentState.copy(
                    isLoading = true
                )
            }

            is StageAction.TestActionCompleted -> {
                Log.d("Logging", "Reducer starting..")
                currentState.copy(
                    isLoading = false,
                    stageList = action.stage
                )
            }

//            is StageAction.LoadingNextChecklist2 -> {
//                currentState.copy(
//                    stageList = action.stage.map { it.copy(name = "${it.name} AA") }
//                )
//            }

            else -> currentState
        }
    }

}