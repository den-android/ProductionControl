package net.denis.productioncontrol.features.stage_checklist.model

import net.denis.productioncontrol.core.data.datasources.local.entities.ChecklistItemEntity

data class ChecklistItem(
    val checklistItemId: Int,
    val stageId: Int,
    val statusId: Int,
    val message: String,
) {
    fun toCompletedChecklistItemEntity() = ChecklistItemEntity(
        checklistItemId = checklistItemId,
        stageId = stageId,
        statusCode = statusId,
        statusMessage = message,
    )
}