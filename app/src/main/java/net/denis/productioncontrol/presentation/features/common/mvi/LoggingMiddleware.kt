package net.denis.productioncontrol.presentation.features.common.mvi

import android.util.Log
import net.denis.productioncontrol.presentation.redux.Action
import net.denis.productioncontrol.presentation.redux.Middleware
import net.denis.productioncontrol.presentation.redux.State
import net.denis.productioncontrol.presentation.redux.Store

class LoggingMiddleware<S: State, A: Action> : Middleware<S, A> {
    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        Log.v(
            "LoggingMiddleware",
            "Processing action: $action Current state: $currentState"
        )
    }
}