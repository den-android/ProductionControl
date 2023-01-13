package net.denis.productioncontrol.data.remote

import kotlinx.coroutines.delay
import net.denis.productioncontrol.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.data.remote.dto.ChecklistDto
import net.denis.productioncontrol.data.remote.dto.StageDto
import javax.inject.Inject

class RemoteDataSource @Inject constructor() : IRemoteDataSource {

    //TODO(Implement a check from Retrofit.Response<>)

    override suspend fun getStage(): List<StageDto> {
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