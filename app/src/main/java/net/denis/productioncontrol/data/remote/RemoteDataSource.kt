package net.denis.productioncontrol.data.remote

import net.denis.productioncontrol.data.remote.dto.AssemblyStageDto
import net.denis.productioncontrol.data.repository.IRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: AssemblyStageApi
): IRemoteDataSource {

    override suspend fun getAssemblyStage(): List<AssemblyStageDto> {
        return api.getAssemblyStage()
    }

}