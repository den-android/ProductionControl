package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.data.model.StageData

interface ILocalDataSource {

    suspend fun addStageItem(stageData: StageData)
    suspend fun getStageItem(id: Int): StageData

    suspend fun addStageItems(stagesData: List<StageData>)
    suspend fun getStageItems(): List<StageData>

    suspend fun updateStageItem(stageData: StageData)

    suspend fun deleteStageItemById(id: Int)

}