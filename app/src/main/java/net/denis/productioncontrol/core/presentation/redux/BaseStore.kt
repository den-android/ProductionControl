package net.denis.productioncontrol.core.presentation.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseStore<S : State, A : Action>(
    initialState: S,
    private val reducer: Reducer<S, A>,
    private val middlewares: List<Middleware<S, A>> = emptyList(),
) : Store<S, A> {

    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<S> = _state

    private val currentState: S
        get() = _state.value

    override suspend fun dispatch(action: A) {

        middlewares.forEach { middleware ->
            middleware.process(action, currentState, this)
        }

        val newState = reducer.reduce(currentState, action)
        _state.value = newState
    }
}