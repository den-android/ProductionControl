package net.denis.productioncontrol.features.stage_checklist.presentation.model

data class CollectedChecklist(
    val stageId: Int,
    val checklistResult: List<Int>,
)