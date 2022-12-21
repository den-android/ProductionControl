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
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import net.denis.productioncontrol.presentation.mvi.Event
import net.denis.productioncontrol.presentation.mvi.AssemblyStageState
import net.denis.productioncontrol.presentation.state.ChecklistState
import javax.inject.Inject

@HiltViewModel
class AssemblyStageViewModel @Inject constructor(
    private val assemblyStageRepository: IAssemblyStageRepository,
    private val checklistRepository: IChecklistRepository
) : ViewModel() {

    val event: Channel<Event> = Channel(Channel.UNLIMITED)

    private val _state = MutableStateFlow<AssemblyStageState>(AssemblyStageState.Idle)
    val state: StateFlow<AssemblyStageState>
        get() = _state


    private val _stateChecklist = mutableStateOf(ChecklistState())
    val stateChecklist: State<ChecklistState> = _stateChecklist

    fun handleIntent() {
        viewModelScope.launch(Dispatchers.IO) {
            event.consumeAsFlow().collect {
                when (it) {
                    is Event.getAssemblyStage -> fetchAssemblyStage()
                }
            }
        }
    }

    private fun fetchAssemblyStage() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = AssemblyStageState.Loading
            _state.value = try {
                AssemblyStageState.Success(assemblyStageRepository.getAssemblyStage())
            } catch (e: Exception) {
                AssemblyStageState.Error(e.localizedMessage)
            }
        }
    }

}