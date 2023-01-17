package net.denis.productioncontrol.features.stage_checklist.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageRepository
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage
import javax.inject.Inject

class StageRepository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
) : IStageRepository {

    override suspend fun getStage(): Flow<List<Stage>> {
        return flow {
            val data = remoteDataSource.getStage()
            emit(data.map { it.toStage() })
        }
    }

}