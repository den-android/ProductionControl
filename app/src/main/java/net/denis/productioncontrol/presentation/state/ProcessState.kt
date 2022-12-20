package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.Process

data class ProcessState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val process: List<Process> = emptyList()
)