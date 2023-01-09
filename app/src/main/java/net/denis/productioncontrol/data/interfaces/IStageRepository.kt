package net.denis.productioncontrol.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.presentation.model.Stage
import net.denis.productioncontrol.util.Result

interface IStageRepository {

    suspend fun getStage(): Flow<Result<List<Stage>>>

}