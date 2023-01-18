package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage

interface IStageRepository {

    suspend fun getTestStage(): Flow<List<Stage>>

    suspend fun sendChecklist(stageId: Int, checklistResult: List<Int>): Boolean
}