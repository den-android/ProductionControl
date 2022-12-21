package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.AssemblyStage

sealed class AssemblyStageViewState {
    object Idle : AssemblyStageViewState()
    object Loading : AssemblyStageViewState()
    class Error(val message: String?) : AssemblyStageViewState()
    class Success(val data: List<AssemblyStage>) : AssemblyStageViewState()
}
