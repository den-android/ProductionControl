package net.denis.productioncontrol.features.stage_checklist.mvi

import android.util.Log
import kotlinx.coroutines.flow.collect
import net.denis.productioncontrol.core.data.interfaces.IStageRepository
import net.denis.productioncontrol.core.presentation.redux.Middleware
import net.denis.productioncontrol.core.presentation.redux.Store
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem

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

            is StageAction.FillChecklistItem -> {
                action.checklistItem?.let { checklistItem ->
                    saveChecklistItem(data = checklistItem, store = store)
                    if ((checklistItem.statusId == 2) || (currentState.stageList[checklistItem.stageId].checklist.size == checklistItem.checklistItemId + 1)) {
                        send(checklistItem.stageId)
                    }

                }
            }

            else -> currentState
        }
    }

    private suspend fun save() {

    }

    private suspend fun send(stageId: Int) {
        stageRepository.getAllChecklistByStageId(stageId).collect() {
            Log.d("Logging", "${it}")
        }
    }

    private suspend fun stageLoading(store: Store<StageState, StageAction>) {
        stageRepository.getTestStage().collect { data ->
            store.dispatch(StageAction.StageLoaded(data))
        }
    }

    private suspend fun saveChecklistItem(
        data: ChecklistItem,
        store: Store<StageState, StageAction>
    ) {
        stageRepository.addChecklistItem(data)
    }

    private suspend fun sendChecklist(stageId: Int) {
        stageRepository.removeAllChecklistItems(stageId = stageId)
    }
}
