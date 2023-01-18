package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import android.util.Log
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageRepository
import net.denis.productioncontrol.core.presentation.redux.Middleware
import net.denis.productioncontrol.core.presentation.redux.Store
import net.denis.productioncontrol.features.stage_checklist.presentation.model.CompletedChecklistItem

class StageDataMiddleware(
    private val stageRepository: IStageRepository,
) : Middleware<StageState, StageAction> {

    override suspend fun process(
        action: StageAction,
        currentState: StageState,
        store: Store<StageState, StageAction>
    ) {
        when (action) {
            is StageAction.StageLoading -> {
                stageLoading(store)
            }

            is StageAction.SendChecklistItems -> {
                val data: CompletedChecklistItem = action.completedChecklistItem
                stageRepository.addChecklistItem(data)
//                val sendStatus: Boolean = stageRepository.addChecklistItem(
//                    completedChecklistItem = data
//                )
//                if (sendStatus == true) {
//                    Log.d("Logging", "" +
//                            "\n[StageDataMiddleware]" +
//                            "\nSUCCESS - ${sendStatus}" +
//                            "")
//                } else {
//                    Log.d("Logging", "" +
//                            "\n[StageDataMiddleware]" +
//                            "\nFAILURE - ${sendStatus}" +
//                            "")
//                }
            }

            else -> currentState
        }
    }

    private suspend fun stageLoading(store: Store<StageState, StageAction>) {
        stageRepository.getTestStage().collect { data ->
            store.dispatch(StageAction.StageLoaded(data))
        }
    }

}