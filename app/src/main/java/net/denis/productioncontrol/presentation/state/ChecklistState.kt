package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.Checklist

data class ChecklistState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val listChecklist: List<Checklist> = emptyList()
)