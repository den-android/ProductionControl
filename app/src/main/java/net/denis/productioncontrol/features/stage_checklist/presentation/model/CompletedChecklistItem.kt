package net.denis.productioncontrol.features.stage_checklist.presentation.model

import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities.CompletedChecklistItemEntity

data class CompletedChecklistItem(
    val stageId: Int,
    val checklistItemId: Int,
    val statusCode: Int,
    val message: String?,
) {
    fun toCompletedChecklistItemEntity() = CompletedChecklistItemEntity(
        stageId = stageId,
        checklistItemId = checklistItemId,
        statusCode = statusCode,
        statusMessage = message,
    )
}