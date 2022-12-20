package net.denis.productioncontrol.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import net.denis.productioncontrol.domain.repository.IProductionProcessRepository
import net.denis.productioncontrol.presentation.state.ChecklistState
import net.denis.productioncontrol.presentation.state.ProductionProcessState
import javax.inject.Inject

@HiltViewModel
class ProductionProcessViewModel @Inject constructor(
    private val productionProcessRepository: IProductionProcessRepository,
    private val checklistRepository: IChecklistRepository
): ViewModel() {

    private val _stateProductionProcess = mutableStateOf(ProductionProcessState())
    val stateProductionProcess: State<ProductionProcessState> = _stateProductionProcess

    private val _stateChecklist = mutableStateOf(ChecklistState())
    val stateChecklist: State<ChecklistState> = _stateChecklist


    
}