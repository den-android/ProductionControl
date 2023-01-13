package net.denis.productioncontrol.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.presentation.model.Stage

interface IStageRepository {

    suspend fun getStage(): Flow<List<Stage>>
    suspend fun getStageTest(): Flow<List<Stage>>

}