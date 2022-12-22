package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.AssemblyStage

data class AssemblyStageState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val assemblyStageList: List<AssemblyStage> = emptyList()
)
