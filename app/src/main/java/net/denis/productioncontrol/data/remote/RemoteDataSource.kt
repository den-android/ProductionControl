package net.denis.productioncontrol.data.remote

import net.denis.productioncontrol.data.remote.dto.AssemblyStageDto
import net.denis.productioncontrol.data.repository.IRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(

): IRemoteDataSource {
    override suspend fun getAssemblyStage(): List<AssemblyStageDto> {
        TODO("Not yet implemented")
    }
}