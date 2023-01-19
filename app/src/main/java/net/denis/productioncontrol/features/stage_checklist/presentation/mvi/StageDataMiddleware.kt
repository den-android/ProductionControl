package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageRepository
import net.denis.productioncontrol.core.presentation.redux.Middleware
import net.denis.productioncontrol.core.presentation.redux.Store
import net.denis.productioncontrol.features.stage_checklist.presentation.model.ChecklistItem

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

            is StageAction.SendingChecklistItem -> {
                currentState.completedChecklist?.let {
                    sendChecklistItems(data = it, store = store)
                }
            }

            is StageAction.SentChecklistItem -> {
                currentState.completedChecklist?.let {
                    sentChecklistItem(stageId = it.stageId, store = store)
                }
            }

            else -> currentState
        }
    }

    private suspend fun sendChecklistItems(data: ChecklistItem, store: Store<StageState, StageAction>) {
        stageRepository.addChecklistItem(data)
        if (data.statusId == 2) {
            store.dispatch(StageAction.SentChecklistItem)
        }
    }

    private suspend fun sentChecklistItem(stageId: Int, store: Store<StageState, StageAction>) {
        stageRepository.removeChecklistItemByStageId(stageId)
    }

    private suspend fun stageLoading(store: Store<StageState, StageAction>) {
        stageRepository.getTestStage().collect { data ->
            store.dispatch(StageAction.StageLoaded(data))
        }
    }

}