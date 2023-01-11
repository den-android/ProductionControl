package net.denis.productioncontrol.presentation.features.stage.mvi

import net.denis.productioncontrol.presentation.features.common.mvi.StageViewState
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

//            is StageAction.LoadedNextChecklist -> {
//                Log.d("Logging", "Reduce: ${action.currentId}")
//                currentState.copy(
//                    stageList = currentState.stageList.map { stage ->
//                        stage.copy(
//                            checklist = stage.checklist.map { checklist ->
//                                checklist.copy(
//                                    id = action.currentId + 1
//                                )
//                            }
//                        )
//                    }
//                )
//            }

            else -> currentState
        }
    }

}