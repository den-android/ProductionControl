package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import net.denis.productioncontrol.core.util.NetworkResult
import net.denis.productioncontrol.features.stage_checklist.data.datasources.remote.dto.StageDto
import net.denis.productioncontrol.features.stage_checklist.presentation.model.ChecklistItem

interface IRemoteDataSource {

//    suspend fun getStage(): NetworkResult<List<StageDto>>
//
    suspend fun getTestStage(): List<StageDto>

    suspend fun sendCompletedChecklist(checklistItem: ChecklistItem): Boolean
}