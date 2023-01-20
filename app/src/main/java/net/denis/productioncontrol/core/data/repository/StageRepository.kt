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

    override suspend fun sendChecklist(completedChecklist: List<ChecklistItem>): Boolean {
        val response = remoteDataSource.sendChecklist(completedChecklist)
        val data = completedChecklist

        return true

    }

    override suspend fun addChecklistItem(checklistItem: ChecklistItem) {
        localDataSource.addChecklistItem(checklistItem.toCompletedChecklistItemEntity())
    }

    override suspend fun removeAllChecklistItems(stageId: Int) {

        localDataSource.removeAllChecklistItems(stageId)
    }

}