package net.denis.productioncontrol.core.data.datasources.local

import net.denis.productioncontrol.core.data.datasources.local.entities.ChecklistItemEntity
import net.denis.productioncontrol.core.data.interfaces.IChecklistDao
import net.denis.productioncontrol.core.data.interfaces.ILocalDataSource
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val checklistDao: IChecklistDao,
) : ILocalDataSource {

    override suspend fun addChecklistItem(checklistItemEntity: ChecklistItemEntity) {
        checklistDao.addChecklistItem(checklistItemEntity)
    }

    override suspend fun removeAllChecklistItems(stageId:Int) {
        checklistDao.removeAllChecklistItems(stageId)
    }

}