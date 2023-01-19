package net.denis.productioncontrol.features.stage_checklist.data.datasources.local

import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities.ChecklistItemEntity
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IChecklistDao
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.ILocalDataSource
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val checklistDao: IChecklistDao,
) : ILocalDataSource {

    override suspend fun addChecklistItem(checklistItemEntity: ChecklistItemEntity) {
        checklistDao.addChecklistItem(checklistItemEntity)
    }

    override suspend fun removeChecklistItemByStageId(stageId: Int) {
        checklistDao.removeChecklistItemByStageId(stageId)
    }

}