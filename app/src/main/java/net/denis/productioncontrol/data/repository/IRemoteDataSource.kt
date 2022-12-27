package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.data.remote.dto.StageDto

interface IRemoteDataSource {

    suspend fun getStage(): List<StageDto>

}