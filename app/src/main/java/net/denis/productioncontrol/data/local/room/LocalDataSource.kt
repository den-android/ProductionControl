package net.denis.productioncontrol.data.local.room

import net.denis.productioncontrol.data.local.room.dao.StageDao
import net.denis.productioncontrol.data.model.StageData
import net.denis.productioncontrol.data.repository.ILocalDataSource
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: StageDao
) : ILocalDataSource {

    override suspend fun addStageItem(stageData: StageData) {
        return dao.addStageItem(stage = stageData.toStageEntity())
    }

    override suspend fun getStageItem(id: Int): StageData {
        val stage = dao.getStageItem(id = id)
        return stage.toStageData()
    }

    override suspend fun addStageItems(stagesData: List<StageData>) {
        return dao.addStageItems(stages = stagesData.map { it.toStageEntity() })
    }

    override suspend fun getStageItems(): List<StageData> {
        val stageList = dao.getStageItems()
        return stageList.map { it.toStageData() }
    }

    override suspend fun updateStageItem(stageData: StageData) {
        return dao.updateStageItem(stage = stageData.toStageEntity())
    }

    override suspend fun deleteStageItemById(id: Int) {
        return dao.deleteStageItemById(id = id)
    }
}