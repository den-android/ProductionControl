package net.denis.productioncontrol.domain.repository

import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.domain.util.Result

interface IAssemblyStageRepository {
    suspend fun getAssemblyStage(): Result<List<AssemblyStage>>
}