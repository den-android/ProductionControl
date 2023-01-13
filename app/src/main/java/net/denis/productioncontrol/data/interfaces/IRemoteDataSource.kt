package net.denis.productioncontrol.data.interfaces

import net.denis.productioncontrol.data.remote.dto.StageDto

interface IRemoteDataSource {

    suspend fun getStage(): List<StageDto>

    suspend fun getStageTest(): List<StageDto>

}