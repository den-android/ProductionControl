package net.denis.productioncontrol.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.productioncontrol.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.data.interfaces.IStageRepository
import net.denis.productioncontrol.presentation.model.Stage
import javax.inject.Inject

class StageRepository @Inject constructor(
    private val IRemoteDataSource: IRemoteDataSource,
) : IStageRepository {

    override suspend fun getStage(): Flow<List<Stage>> {
        return flow {
            val data = IRemoteDataSource.getStage()
            emit(data.map { it.toStage() })
        }
    }

}