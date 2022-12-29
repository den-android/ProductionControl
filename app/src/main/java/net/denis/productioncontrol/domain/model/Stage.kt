package net.denis.productioncontrol.domain.model

data class Stage(
    val id: Int,
    val name: String,
    val checklist: List<Checklist>
)