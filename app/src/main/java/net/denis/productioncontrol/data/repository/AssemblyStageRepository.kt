package net.denis.productioncontrol.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import net.denis.productioncontrol.util.Result
import javax.inject.Inject

class AssemblyStageRepository @Inject constructor(
    private val ILocalDataSource: ILocalDataSource,
    private val IRemoteDataSource: IRemoteDataSource,
) : IAssemblyStageRepository {

    override suspend fun getAssemblyStage(): Flow<Result<List<AssemblyStage>>> {
        return flow {
            try {
                val data = IRemoteDataSource.getAssemblyStage()
                ILocalDataSource.addAssemblyStageItems(data.map { it.toAssemblyStageData() })
                emit(Result.Success(data.map { it.toAssemblyStage() }))
            } catch (e: Exception) {
                try {
                    val local = ILocalDataSource.getAssemblyStageItems()
                    emit(Result.Success(local.map { it.toAssemblyStage() }))
                } catch (e: Exception) {
                    emit(Result.Error(message = e.localizedMessage))
                }
            }
        }
    }

    override suspend fun saveAssemblyStage(stage: AssemblyStage) {
        TODO("Not yet implemented")
    }
}