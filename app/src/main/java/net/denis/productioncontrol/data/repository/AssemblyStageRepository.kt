package net.denis.productioncontrol.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import net.denis.productioncontrol.util.Result
import javax.inject.Inject

class AssemblyStageRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: Mapper<>
) : IAssemblyStageRepository {

    override suspend fun getAssemblyStage(): Flow<Result<List<AssemblyStage>>> {
        return flow {
            try {
                val data = remoteDataSource.getAssemblyStage().map{it}

                emit(Result.Success(data))
            } catch (e: Exception) {
                try {
                    val local = localDataSource
                }
            }
        }
    }

//    private val remoteDataSource = (1..5).map {
//        AssemblyStage(
//            id = it,
//            name = "Process name $it",
//            checklist = listOf(
//                Checklist(
//                    id = it,
//                    name = "#$it checklistItem name $it"
//                )
//            )
//        )
//    }
}