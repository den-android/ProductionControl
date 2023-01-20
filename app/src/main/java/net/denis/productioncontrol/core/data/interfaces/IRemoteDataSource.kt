package net.denis.productioncontrol.core.data.interfaces

import net.denis.productioncontrol.core.data.datasources.remote.dto.StageDto
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem

interface IRemoteDataSource {

//    suspend fun getStage(): NetworkResult<List<StageDto>>
//
    suspend fun getTestStage(): List<StageDto>

    suspend fun sendChecklist(completedChecklist: List<ChecklistItem>): Boolean
}