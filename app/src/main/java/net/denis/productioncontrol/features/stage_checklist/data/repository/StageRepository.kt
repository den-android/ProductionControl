package net.denis.productioncontrol.features.stage_checklist.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.ILocalDataSource
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageRepository
import net.denis.productioncontrol.features.stage_checklist.presentation.model.ChecklistItem
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage
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

    override suspend fun sendCompletedChecklist(checklistItem: ChecklistItem) {
        val response = remoteDataSource.sendCompletedChecklist(checklistItem)
        if (response) {
            removeAllChecklistItems(checklistItem.stageId)
        }
    }

//    override suspend fun getStage(): Flow<List<Stage>> {
//        TODO("Get response from retrofit here")
//    }

    override suspend fun addChecklistItem(checklistItem: ChecklistItem) {
        localDataSource.addChecklistItem(checklistItem.toCompletedChecklistItemEntity())
    }

    override suspend fun removeAllChecklistItems(stageId:Int) {
        localDataSource.removeAllChecklistItems(stageId)
    }

}