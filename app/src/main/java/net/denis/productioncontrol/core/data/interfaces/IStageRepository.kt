package net.denis.productioncontrol.core.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem
import net.denis.productioncontrol.features.stage_checklist.model.Stage

interface IStageRepository {

    //suspend fun getStage(): Flow<List<Stage>>
    suspend fun getTestStage(): Flow<List<Stage>>

    suspend fun addChecklistItem(checklistItem: ChecklistItem)
    suspend fun removeAllChecklistItems(stageId: Int)
    //suspend fun getAllChecklistByStageId(stageId: Int): Flow<List<ChecklistItem>>

    suspend fun sendCompletedChecklist(stageId: Int): Boolean
}
