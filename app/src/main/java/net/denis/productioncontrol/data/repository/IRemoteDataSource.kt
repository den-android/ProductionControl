package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.data.remote.dto.AssemblyStageDto

interface IRemoteDataSource {

    suspend fun getAssemblyStage(): List<AssemblyStageDto>

}