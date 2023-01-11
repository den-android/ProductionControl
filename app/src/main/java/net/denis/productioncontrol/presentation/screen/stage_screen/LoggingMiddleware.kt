package net.denis.productioncontrol.presentation.screen.stage_screen

import android.util.Log
import net.denis.productioncontrol.presentation.redux.*

class LoggingMiddleware<S: State, A: Action> : Middleware<S, A> {
    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        Log.v(
            "LoggingMiddleware",
            "Processing action: $action Current state: $currentState"
        )
    }
}