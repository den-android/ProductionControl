package net.denis.productioncontrol.domain.repository

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.util.Result

interface IAssemblyStageRepository {
    suspend fun getAssemblyStage(): Flow<Result<List<AssemblyStage>>>
}