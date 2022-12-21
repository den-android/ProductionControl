package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.data.model.AssemblyStageData

interface LocalDataSource {

    suspend fun addAssemblyStageItem(item: AssemblyStageData): Int
    suspend fun getAssemblyStageItem(id: Int): AssemblyStageData

    suspend fun addAssemblyStageItems(items: List<AssemblyStageData>): List<Int>
    suspend fun getAssemblyStageItems(): List<AssemblyStageData>

    suspend fun updateAssemblyStageItem(item: AssemblyStageData): Int

    suspend fun deleteAssemblyStageItemById(id: Int): Int

}