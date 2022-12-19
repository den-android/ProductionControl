package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.ChecklistItem

data class ChecklistState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val checklist: List<ChecklistItem> = emptyList()
)