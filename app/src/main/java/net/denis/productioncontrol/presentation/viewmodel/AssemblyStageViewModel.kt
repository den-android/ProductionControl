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
import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import net.denis.productioncontrol.presentation.intent.AssemblyStageIntent
import net.denis.productioncontrol.presentation.state.AssemblyStageState
import net.denis.productioncontrol.presentation.state.ChecklistState
import net.denis.productioncontrol.presentation.state.AssemblyStageViewState
import javax.inject.Inject

@HiltViewModel
class AssemblyStageViewModel @Inject constructor(
    private val assemblyStageRepository: IAssemblyStageRepository,
    private val checklistRepository: IChecklistRepository
) : ViewModel() {

    val assemblyStageIntent: Channel<AssemblyStageIntent> = Channel(Channel.UNLIMITED)

    private val _state = MutableStateFlow<AssemblyStageViewState>(AssemblyStageViewState.Idle)
    val state: StateFlow<AssemblyStageViewState>
        get() = _state

    private val _stateAssemblyStage = mutableStateOf(AssemblyStageState())
    val stateAssemblyStage: State<AssemblyStageState> = _stateAssemblyStage

    private val _stateChecklist = mutableStateOf(ChecklistState())
    val stateChecklist: State<ChecklistState> = _stateChecklist

    fun handleIntent() {
        viewModelScope.launch(Dispatchers.IO) {
            assemblyStageIntent.consumeAsFlow().collect {
                when (it) {
                    is AssemblyStageIntent.getAssemblyStage -> fetchAssemblyStage()
                }
            }
        }
    }

    private fun fetchAssemblyStage() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = AssemblyStageViewState.Loading
            _state.value = try {
                AssemblyStageViewState.Success(assemblyStageRepository.getAssemblyStage())
            } catch (e: Exception) {
                AssemblyStageViewState.Error(e.localizedMessage)
            }
        }
    }

}