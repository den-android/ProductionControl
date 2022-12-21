package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.domain.model.Checklist
import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import net.denis.productioncontrol.domain.util.Result
import javax.inject.Inject

class AssemblyStageRepository @Inject constructor(

) : IAssemblyStageRepository {
    override suspend fun getProcess(): Result<List<java.lang.Process>> {
        TODO("Not yet implemented")
    }

    private val remoteDataSource = (1..5).map {
        AssemblyStage(
            id = it,
            name = "Process name $it",
            checklist = listOf(
                Checklist(
                    id = it,
                    name = "#$it checklistItem name $it"
                )
            )
        )
    }
}