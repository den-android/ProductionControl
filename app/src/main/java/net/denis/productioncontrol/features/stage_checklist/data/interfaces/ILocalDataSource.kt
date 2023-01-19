package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities.ChecklistItemEntity
import net.denis.productioncontrol.features.stage_checklist.presentation.model.ChecklistItem

interface ILocalDataSource {

    suspend fun addChecklistItem(checklistItemEntity: ChecklistItemEntity)

    suspend fun removeAllChecklistItems(stageId: Int)

}