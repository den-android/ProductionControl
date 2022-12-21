package net.denis.productioncontrol.presentation.mvi

import net.denis.productioncontrol.domain.model.AssemblyStage

sealed class AssemblyStageState {
    object Idle : AssemblyStageState()
    object Loading : AssemblyStageState()
    class Error(val message: String?) : AssemblyStageState()
    class Success(val data: List<AssemblyStage>) : AssemblyStageState()
}