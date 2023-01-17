package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import net.denis.productioncontrol.features.stage_checklist.data.datasources.remote.dto.StageDto

interface IRemoteDataSource {

    suspend fun getStage(): List<StageDto>

}