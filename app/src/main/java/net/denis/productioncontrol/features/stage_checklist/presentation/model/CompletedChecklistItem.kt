package net.denis.productioncontrol.features.stage_checklist.presentation.model

data class CompletedChecklistItem(
    val stageId: Int,
    val statusCode: Int,
    val message: String?,
)