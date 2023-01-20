package net.denis.productioncontrol.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.productioncontrol.core.data.interfaces.ILocalDataSource
import net.denis.productioncontrol.core.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.core.data.interfaces.IStageRepository
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem
import net.denis.productioncontrol.features.stage_checklist.model.Stage
import javax.inject.Inject

class StageRepository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource,
) : IStageRepository {

    override suspend fun getTestStage(): Flow<List<Stage>> {
        return flow {
            val data = remoteDataSource.getTestStage()
            emit(data.map { it.toStage() })
        }
    }

    override suspend fun sendCompletedChecklist(stageId: Int): Boolean {
        val data = getAllChecklistByStageId(stageId)
        if (remoteDataSource.sendChecklist(data)) {
            removeAllChecklistItems(stageId)
            return true
        } else {
            return false
        }
    }

    override suspend fun addChecklistItem(checklistItem: ChecklistItem) {
        localDataSource.addChecklistItem(checklistItem.toCompletedChecklistItemEntity())
    }

    private suspend fun getAllChecklistByStageId(stageId: Int): List<ChecklistItem> {
        return localDataSource.getAllChecklistByStageId(stageId).map { it.toChecklistItem() }
    }

    override suspend fun removeAllChecklistItems(stageId: Int) {
        localDataSource.removeAllChecklistItems(stageId)
    }

}