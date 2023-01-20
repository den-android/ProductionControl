package net.denis.productioncontrol.core.data.interfaces

import net.denis.productioncontrol.core.data.datasources.local.entities.ChecklistItemEntity
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem

interface ILocalDataSource {

    suspend fun addChecklistItem(checklistItemEntity: ChecklistItemEntity)

    suspend fun removeAllChecklistItems(stageId: Int)

    suspend fun getAllChecklistByStageId(stageId: Int): List<ChecklistItemEntity>
}