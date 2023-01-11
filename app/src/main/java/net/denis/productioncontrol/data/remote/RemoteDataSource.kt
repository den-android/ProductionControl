package net.denis.productioncontrol.data.remote

import kotlinx.coroutines.delay
import net.denis.productioncontrol.data.remote.dto.ChecklistDto
import net.denis.productioncontrol.data.remote.dto.StageDto
import net.denis.productioncontrol.data.interfaces.IRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(

) : IRemoteDataSource {

    override suspend fun getStage(): List<StageDto> {
        // Response<>
        delay(1000L)
        val data = testRemoteDataSource
        return data
    }

    private val remoteDataSource = (0..9).map { stage ->
        StageDto(
            id = stage,
            name = "Name Stage $stage",
            checklistDto = (1..3).map { check->
                ChecklistDto(
                    id = check,
                    name = "Stage:$stage ChecklistItem:$check"
                )
            }

        )
    }

    private val testRemoteDataSource: List<StageDto> = listOf(
        StageDto(0, "0 stage", checklistDto = listOf(
            ChecklistDto(0,"Нулевой6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666 чеклист")
        )),

        StageDto(1, "First stage", checklistDto = listOf(
            ChecklistDto(0,"zero checklist"),
            ChecklistDto(1,"first checklist"),
            ChecklistDto(2,"second checklist"),
        )),

        StageDto(2, "2nd stage", checklistDto = listOf(
            ChecklistDto(0,"0-rd checklist"),
            ChecklistDto(1,"1-rd checklist"),
            ChecklistDto(2,"2-rd checklist"),
            ChecklistDto(3,"3-rd checklist"),
            ChecklistDto(4,"4-rd checklist"),
            ChecklistDto(5,"5-rd checklist"),
            ChecklistDto(6,"6-rd checklist"),
        )),

    )

}