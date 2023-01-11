package net.denis.productioncontrol.presentation.features.stage.mvi

import net.denis.productioncontrol.data.interfaces.IStageRepository
import net.denis.productioncontrol.presentation.features.common.mvi.StageViewState
import net.denis.productioncontrol.presentation.features.common.mvi.LoggingMiddleware
import net.denis.productioncontrol.presentation.redux.BaseStore
import javax.inject.Inject

class StageStore @Inject constructor(
    stageRepository: IStageRepository,
) : BaseStore<StageViewState, StageAction>(
    initialState = StageViewState(),
    reducer = StageReducer(),
    middlewares = listOf(
        //LoggingMiddleware(),
        StageDataMiddleware(stageRepository),
    )
)