package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities.CompletedChecklistItemEntity
import net.denis.productioncontrol.features.stage_checklist.presentation.model.CompletedChecklistItem

interface ILocalDataSource {

    suspend fun addChecklistItem(completedChecklistItemEntity: CompletedChecklistItemEntity)

}