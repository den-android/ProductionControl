package net.denis.productioncontrol.presentation.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, > : ViewModel() {

    private val initialState : UiState by lazy { setInitialState() }
    abstract fun setInitialState() : UiState

    private val _viewState : MutableState<UiState> = mutableStateOf(initialState)
    val viewState: State<UiState> = _viewState

    private val _event : MutableSharedFlow<Event> = MutableSharedFlow()

    init {
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        viewModelScope.launch {
            _event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun handleEvent(event : Event)

    fun setEvent(event : Event) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    protected fun setState(reduce: UiState.() -> UiState) {
        val newState = viewState.value.reduce()
        _viewState.value = newState
    }

}