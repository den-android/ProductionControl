package net.denis.productioncontrol.data.remote

import net.denis.productioncontrol.data.remote.dto.ChecklistDto
import net.denis.productioncontrol.data.remote.dto.StageDto
import net.denis.productioncontrol.data.repository.IRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(

) : IRemoteDataSource {

    override suspend fun getStage(): List<StageDto> {
        // Response<>
        val data = remoteDataSource
        return data
    }

    private val remoteDataSource = (1..4).map { stage ->
        StageDto(
            id = stage,
            name = "Name Stage $stage",
            checklistDto = (1..3).map { check->
                ChecklistDto(
                    id = check,
                    name = "$stage ChecklistItem $check"
                )
            }

        )
    }

}