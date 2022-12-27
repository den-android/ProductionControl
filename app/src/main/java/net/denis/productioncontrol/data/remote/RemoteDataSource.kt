package net.denis.productioncontrol.data.remote

import net.denis.productioncontrol.data.remote.dto.StageDto
import net.denis.productioncontrol.data.repository.IRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(

) : IRemoteDataSource {

    override suspend fun getStage(): List<StageDto> {
        val data = remoteDataSource
        return data
    }

    private val remoteDataSource = (1..4).map {
        StageDto(
            id = it,
            name = "Name Stage $it",

        )
    }

}