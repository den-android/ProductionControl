package net.denis.productioncontrol.core.data.interfaces

import net.denis.productioncontrol.core.data.datasources.local.entities.ChecklistItemEntity

interface ILocalDataSource {

    suspend fun addChecklistItem(checklistItemEntity: ChecklistItemEntity)

    suspend fun removeAllChecklistItems(stageId: Int)

}