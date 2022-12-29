package net.denis.productioncontrol.domain.repository

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.domain.model.Stage
import net.denis.productioncontrol.util.Result

interface IStageRepository {

    suspend fun getStage(): Flow<Result<List<Stage>>>

}