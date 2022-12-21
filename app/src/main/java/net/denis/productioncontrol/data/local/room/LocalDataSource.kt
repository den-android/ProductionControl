package net.denis.productioncontrol.data.local.room

import net.denis.productioncontrol.data.local.room.dao.AssemblyStageDao
import net.denis.productioncontrol.data.model.AssemblyStageData
import net.denis.productioncontrol.data.repository.ILocalDataSource
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: AssemblyStageDao
): ILocalDataSource {

    override suspend fun addAssemblyStageItem(stage: AssemblyStageData): Int {
        val assemblyStage = stage
        return dao.addAssemblyStageItem(stage = assemblyStage.toAssemblyStageEntity())
    }

    override suspend fun getAssemblyStageItem(id: Int): AssemblyStageData {
        val assemblyStage = dao.getAssemblyStageItem(id = id)
        return assemblyStage.toAssemblyStageData()
    }

    override suspend fun addAssemblyStageItems(stages: List<AssemblyStageData>): List<Int> {
        val assemblyStageList = stages
        return dao.addAssemblyStageItems(stages = assemblyStageList.map { it.toAssemblyStageEntity() })
    }

    override suspend fun getAssemblyStageItems(): List<AssemblyStageData> {
        val assemblyStageList = dao.getAssemblyStageItems()
        return assemblyStageList.map { it.toAssemblyStageData() }
    }

    override suspend fun updateAssemblyStageItem(stage: AssemblyStageData): Int {
        val assemblyStage = stage
        return dao.updateAssemblyStageItem(stage = assemblyStage.toAssemblyStageEntity())
    }

    override suspend fun deleteAssemblyStageItemById(id: Int): Int {
        return dao.deleteAssemblyStageItemById(id = id)
    }
}