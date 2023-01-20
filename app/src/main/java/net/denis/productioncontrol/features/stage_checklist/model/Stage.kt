package net.denis.productioncontrol.features.stage_checklist.model

data class Stage(
    val id: Int,
    val name: String,
    val checklist: List<Checklist>
)