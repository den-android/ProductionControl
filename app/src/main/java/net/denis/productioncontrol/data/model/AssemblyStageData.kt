package net.denis.productioncontrol.data.model

data class AssemblyStageData (
    val id: Int,
    val name: String,
    val checklistData: ChecklistData
)