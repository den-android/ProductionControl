package net.denis.productioncontrol.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
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

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    private val _state : MutableStateFlow<AssemblyStageState> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()


    fun handleEvent(event: Event) {
        viewModelScope.launch {
            when (event) {
                is Event.onStageClicked -> assemblyStageRepository.getAssemblyStage()
            }
        }
    }

    private fun fetchAssemblyStage() {

    }

}