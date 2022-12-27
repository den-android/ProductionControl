package net.denis.productioncontrol.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.productioncontrol.domain.model.Stage
import net.denis.productioncontrol.domain.repository.IStageRepository
import net.denis.productioncontrol.util.Result
import javax.inject.Inject

class StageRepository @Inject constructor(
    private val ILocalDataSource: ILocalDataSource,
    private val IRemoteDataSource: IRemoteDataSource,
) : IStageRepository {

    override suspend fun getStage(): Flow<Result<List<Stage>>> {
        return flow {
//            try {
//                val data = IRemoteDataSource.getAssemblyStage()
//                ILocalDataSource.addAssemblyStageItems(data.map { it.toAssemblyStageData() })
//                emit(Result.Success(data.map { it.toAssemblyStage() }))
//            } catch (e: Exception) {
//                try {
//                    val local = ILocalDataSource.getAssemblyStageItems()
//                    emit(Result.Success(local.map { it.toAssemblyStage() }))
//                } catch (e: Exception) {
//                    emit(Result.Error(message = e.localizedMessage))
//                }
//            }
            try {
                val data = IRemoteDataSource.getStage()
                emit(Result.Success(data.map{it.toStage()}))
            }catch (e: Exception) {
                emit(Result.Error(message = e.localizedMessage))
            }
        }
    }

    override suspend fun saveStage(stage: Stage) {
        TODO()
        //        try {
//            val data = stage
//            ILocalDataSource.addAssemblyStageItem(data.toAssemblyStageData())
//        } catch (e : Exception) {
//            return e.localizedMessage
//        }
//    }
    }
}