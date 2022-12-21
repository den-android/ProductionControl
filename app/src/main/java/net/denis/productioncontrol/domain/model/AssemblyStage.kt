package net.denis.productioncontrol.domain.model

data class AssemblyStage(
    val id: Int,
    val name: String,
    val checklist: List<Checklist>
)