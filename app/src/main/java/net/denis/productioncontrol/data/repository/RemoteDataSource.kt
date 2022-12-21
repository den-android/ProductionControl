package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.data.remote.dto.AssemblyStageDto


interface RemoteDataSource {

    suspend fun getAssemblyStage(): List<AssemblyStageDto>

}