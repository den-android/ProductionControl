package net.denis.productioncontrol.features.stage_checklist.data.datasources.remote

import kotlinx.coroutines.delay
import net.denis.productioncontrol.core.util.NetworkResult
import net.denis.productioncontrol.core.util.handleApi
import net.denis.productioncontrol.features.stage_checklist.data.datasources.remote.dto.ChecklistDto
import net.denis.productioncontrol.features.stage_checklist.data.datasources.remote.dto.StageDto
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageApi
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val stageApi: IStageApi,
) : IRemoteDataSource {

    override suspend fun getStage(): NetworkResult<List<StageDto>> {
        return handleApi { stageApi.getStage() }
    }

    override suspend fun getTestStage(): List<StageDto> {
        delay(1000L)
        val data = testRemoteDataSource
        return data
    }

    private val testRemoteDataSource: List<StageDto> = listOf(
        StageDto(
            0, "0 stage", checklistDto = listOf(
                ChecklistDto(
                    0,
                    "Нулевой чеклист"
                )
            )
        ),

        StageDto(
            1, "First stage", checklistDto = listOf(
                ChecklistDto(0, "zero checklist"),
                ChecklistDto(1, "first checklist"),
                ChecklistDto(2, "second checklist"),
            )
        ),

        StageDto(
            2, "2nd stage", checklistDto = listOf(
                ChecklistDto(0, "0-rd checklist"),
                ChecklistDto(1, "1-rd checklist"),
                ChecklistDto(2, "2-rd checklist"),
                ChecklistDto(3, "3-rd checklist"),
                ChecklistDto(4, "4-rd checklist"),
                ChecklistDto(5, "5-rd checklist"),
                ChecklistDto(6, "6-rd checklist"),
            )
        ),
    )

    private val smallRemoteDataSource: List<StageDto> = listOf(
        StageDto(
            0, "0 stage", checklistDto = listOf(
                ChecklistDto(0, "zero"),
                ChecklistDto(1, "one"),
            )
        ),
        StageDto(
            1, "1 stage", checklistDto = listOf()
        ),
    )

}