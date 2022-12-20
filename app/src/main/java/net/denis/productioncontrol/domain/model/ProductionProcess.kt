package net.denis.productioncontrol.domain.model

data class ProductionProcess(
    val id: Int,
    val name: String,
    val checklistItem: Checklist
)