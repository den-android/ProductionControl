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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import net.denis.productioncontrol.domain.repository.IProductionProcessRepository
import net.denis.productioncontrol.presentation.state.ChecklistState
import net.denis.productioncontrol.presentation.state.MainViewState
import net.denis.productioncontrol.presentation.state.ProductionProcessState
import javax.inject.Inject

@HiltViewModel
class ProductionProcessViewModel @Inject constructor(
    private val productionProcessRepository: IProductionProcessRepository,
    private val checklistRepository: IChecklistRepository
) : ViewModel() {

    val mainIntent: Channel<MainIntent> = Channel(Channel.UNLIMITED)

    private val _state = MutableStateFlow<MainViewState>(MainViewState.Idle)
    val state: StateFlow<MainViewState>
        get() = _state

    private val _stateProductionProcess = mutableStateOf(ProductionProcessState())
    val stateProductionProcess: State<ProductionProcessState> = _stateProductionProcess

    private val _stateChecklist = mutableStateOf(ChecklistState())
    val stateChecklist: State<ChecklistState> = _stateChecklist

    fun handleIntent() {
        viewModelScope.launch(Dispatchers.IO) {
            mainIntent.consumeAsFlow().collect {
                when (it) {
                    is MainViewState.Loading
                }
            }
        }
    }

}