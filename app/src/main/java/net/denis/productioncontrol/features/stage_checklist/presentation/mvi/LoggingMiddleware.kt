package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import android.util.Log
import net.denis.productioncontrol.core.presentation.redux.*

class LoggingMiddleware<S: State, A: Action> : Middleware<S, A> {
    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        Log.v(
            "LoggingMiddleware",
            "Processing action: $action Current state: $currentState"
        )
    }
}