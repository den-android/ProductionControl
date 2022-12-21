package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.data.model.AssemblyStageData

interface ILocalDataSource {

    suspend fun addAssemblyStageItem(stage: AssemblyStageData): Int
    suspend fun getAssemblyStageItem(id: Int): AssemblyStageData

    suspend fun addAssemblyStageItems(stages: List<AssemblyStageData>): List<Int>
    suspend fun getAssemblyStageItems(): List<AssemblyStageData>

    suspend fun updateAssemblyStageItem(stage: AssemblyStageData): Int

    suspend fun deleteAssemblyStageItemById(id: Int): Int

}