package net.denis.productioncontrol.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import net.denis.productioncontrol.presentation.intent.ProcessIntent
import net.denis.productioncontrol.presentation.state.ChecklistState
import net.denis.productioncontrol.presentation.state.MainViewState
import javax.inject.Inject

@HiltViewModel
class ProcessViewModel @Inject constructor(
    private val processRepository: IProcessRepository,
    private val checklistRepository: IChecklistRepository
) : ViewModel() {

    val processIntent: Channel<ProcessIntent> = Channel(Channel.UNLIMITED)

    private val _state = MutableStateFlow<MainViewState>(MainViewState.Idle)
    val state: StateFlow<MainViewState>
        get() = _state

    private val _stateProcess = mutableStateOf(ProcessState())
    val stateProcess: State<ProcessState> = _stateProcess

    private val _stateChecklist = mutableStateOf(ChecklistState())
    val stateChecklist: State<ChecklistState> = _stateChecklist

    fun handleIntent() {
        viewModelScope.launch(Dispatchers.IO) {
            processIntent.consumeAsFlow().collect {
                when (it) {
                    is ProcessIntent.getProcess -> fetchProcess()
                }
            }
        }
    }

    private fun fetchProcess() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = MainViewState.Loading
            _state.value = try {
                MainViewState.Success(processRepository)
            } catch (e: Exception) {
                MainViewState.Error(e.localizedMessage)
            }
        }
    }

}