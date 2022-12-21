package net.denis.productioncontrol.data.remote.dto

data class AssemblyStageDto(
    val id: Int,
    val name: String,
    val checklist: List<ChecklistDto>
)
