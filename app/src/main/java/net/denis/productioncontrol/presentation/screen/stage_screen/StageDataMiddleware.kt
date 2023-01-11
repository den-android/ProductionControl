package net.denis.productioncontrol.presentation.screen.stage_screen

import android.util.Log
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import net.denis.productioncontrol.data.interfaces.IStageRepository
import net.denis.productioncontrol.data.remote.dto.ChecklistDto
import net.denis.productioncontrol.data.remote.dto.StageDto
import net.denis.productioncontrol.presentation.model.Checklist
import net.denis.productioncontrol.presentation.model.Stage
import net.denis.productioncontrol.presentation.redux.BaseStore
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
            is StageAction.FetchStage -> {
                fetchStage(store)
            }

            is StageAction.LoadNextChecklist -> {
                loadNextChecklist(
                    currentId = action.nextChecklistId,
                    //checklistSize = action.checklist
                )
            }

            else -> currentState
        }
    }

    private suspend fun loadNextChecklist(currentId: Int) {

            currentId + 1
            Log.d("Logging", "SUCCESS${currentId + 1}")

    }

    private suspend fun fetchStage(store: Store<StageViewState, StageAction>) {
        stageRepository.getStage().collect { data ->
            store.dispatch(StageAction.StageDataLoaded(data))
        }


    }

}