package net.denis.productioncontrol.features.stage_checklist.data.datasources.local

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities.CompletedChecklistItemEntity
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.ICompletedChecklistDao
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.ILocalDataSource
import net.denis.productioncontrol.features.stage_checklist.presentation.model.CompletedChecklistItem
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val completedChecklistDao: ICompletedChecklistDao,
) : ILocalDataSource {

    override suspend fun addChecklistItem(completedChecklistItemEntity: CompletedChecklistItemEntity) {
        completedChecklistDao.addChecklistItem(completedChecklistItemEntity)
    }

}