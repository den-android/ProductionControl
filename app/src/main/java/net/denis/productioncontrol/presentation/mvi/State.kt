package net.denis.productioncontrol.presentation.mvi

import net.denis.productioncontrol.domain.model.AssemblyStage

data class State(
    val isLoading: Boolean = false,
    val error: String? = null,
    val assemblyStages: List<AssemblyStage> = emptyList()
)