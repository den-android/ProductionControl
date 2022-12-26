package net.denis.productioncontrol.data.remote

import net.denis.productioncontrol.data.remote.dto.AssemblyStageDto
import net.denis.productioncontrol.data.remote.dto.ChecklistDto
import net.denis.productioncontrol.data.repository.IRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(

) : IRemoteDataSource {

    override suspend fun getAssemblyStage(): List<AssemblyStageDto> {
        val data = remoteDataSource
        return data
    }

    private val remoteDataSource = (1..5).map {
        AssemblyStageDto(
            id = it,
            name = "Name Stage $it",

        )
    }

}