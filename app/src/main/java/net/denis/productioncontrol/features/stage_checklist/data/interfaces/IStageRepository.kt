package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.features.stage_checklist.presentation.model.ChecklistItem
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage

interface IStageRepository {

    //suspend fun getStage(): Flow<List<Stage>>
    suspend fun getTestStage(): Flow<List<Stage>>

    suspend fun addChecklistItem(checklistItem: ChecklistItem)
    suspend fun removeChecklistItemByStageId(stageId: Int)

    suspend fun sendCompletedChecklist(checklistItem: ChecklistItem)
}
