package net.denis.productioncontrol.core.presentation.redux

interface Middleware<S : State, A : Action> {
    suspend fun process(
        action: A,
        currentState: S,
        store: Store<S, A>,
    )
}