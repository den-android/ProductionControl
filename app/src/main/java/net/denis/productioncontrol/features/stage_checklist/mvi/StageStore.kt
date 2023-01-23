package net.denis.productioncontrol.features.stage_checklist.mvi

import net.denis.productioncontrol.core.data.interfaces.IStageRepository
import net.denis.productioncontrol.core.presentation.redux.BaseStore
import javax.inject.Inject

class StageStore @Inject constructor(
    stageRepository: IStageRepository,
) : BaseStore<StageState, StageAction>(
    initialState = StageState(),
    reducer = StageReducer(),
    middlewares = listOf(
        LoggingMiddleware(),
        StageDataMiddleware(stageRepository),
    )
)