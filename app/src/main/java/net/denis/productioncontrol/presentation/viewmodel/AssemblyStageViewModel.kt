package net.denis.productioncontrol.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import javax.inject.Inject

@HiltViewModel
class AssemblyStageViewModel @Inject constructor(
    private val assemblyStageRepository: IAssemblyStageRepository
) : ViewModel() {

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    private val _state : MutableStateFlow<State> = MutableStateFlow(initialState)
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