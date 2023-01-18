package net.denis.productioncontrol.features.stage_checklist.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.ILocalDataSource
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageRepository
import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage
import javax.inject.Inject
import kotlin.random.Random

class StageRepository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource,
) : IStageRepository {

    override suspend fun getTestStage(): Flow<List<Stage>> {
        return flow {
            val data = remoteDataSource.getTestStage()
            emit(data.map { it.toStage() })
        }
    }

    override suspend fun sendChecklist(stageId: Int, checklistResult: List<Int>): Boolean {
        Log.d("Logging", "[Repository]\nAnswers from the checklist: ${stageId}\n${checklistResult}")
        val randomResult: Int = Random.nextInt(0, 3)
        return randomResult != 0
    }

}