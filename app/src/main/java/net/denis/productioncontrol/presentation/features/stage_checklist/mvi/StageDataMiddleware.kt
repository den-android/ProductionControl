package net.denis.productioncontrol.presentation.features.stage_checklist.mvi

import android.util.Log
import net.denis.productioncontrol.data.interfaces.IStageRepository
import net.denis.productioncontrol.presentation.redux.Middleware
import net.denis.productioncontrol.presentation.redux.Store

class StageDataMiddleware(
    private val stageRepository: IStageRepository,
) : Middleware<StageViewState, StageAction> {

    override suspend fun process(
        action: StageAction,
        currentState: StageViewState,
        store: Store<StageViewState, StageAction>
    ) {
        when (action) {
            is StageAction.StageLoading -> {
                stageLoading(store)
            }

            is StageAction.ChecklistLoading -> {
                Log.d("Logging", "Pressed checklistId = ${action.currentId}")
                //TODO("add business-logic after statusButton click")

            }

            else -> currentState
        }
    }

    private suspend fun stageLoading(store: Store<StageViewState, StageAction>) {
        stageRepository.getStage().collect { data ->
            store.dispatch(StageAction.StageLoaded(data))
        }
    }

}