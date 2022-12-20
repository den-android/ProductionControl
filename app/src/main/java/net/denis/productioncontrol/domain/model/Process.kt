package net.denis.productioncontrol.domain.model

data class Process(
    val id: Int,
    val name: String,
    val checklist: List<Checklist>
)