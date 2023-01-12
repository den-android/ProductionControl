package net.denis.productioncontrol.presentation.features.stage_checklist.mvi

import android.util.Log
import androidx.compose.runtime.currentComposer
import net.denis.productioncontrol.data.interfaces.IStageRepository
import net.denis.productioncontrol.presentation.model.Checklist
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

//            is StageAction.ChecklistLoading ->{
//                checklistLoading(store)
//            }

            is StageAction.TestActionLoading -> {
                Log.d("Logging", "Middleware (when) TEST ACTION")
                funTestAction(store)
            }

            else -> currentState
        }
    }

    private suspend fun funTestAction(store: Store<StageViewState, StageAction>) {

        stageRepository.getStage().collect { data ->
            data.map { it.toTestAction() }
            Log.d("Logging", "${data}")
            store.dispatch(StageAction.TestActionCompleted(stage = data))
        }

    }

    /**
     * val data = currentState.stageList
    data.forEach { stage ->
    stage.name.map { it + "123" }
    }
     */


//    private suspend fun checklistLoading(store: Store<StageViewState, StageAction>) {
//        store.dispatch(StageAction.LoadingNextChecklist1(Checklist(4,"123")))
//        Log.d("Logging", "SOME LOGIC")
//    }

    private suspend fun stageLoading(store: Store<StageViewState, StageAction>) {
        stageRepository.getStage().collect { data ->
            store.dispatch(StageAction.StageLoaded(data))
        }
    }

}