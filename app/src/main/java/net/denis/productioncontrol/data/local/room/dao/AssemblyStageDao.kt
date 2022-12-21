package net.denis.productioncontrol.data.local.room.dao

import androidx.room.*
import net.denis.productioncontrol.data.local.room.entities.AssemblyStageEntity
import net.denis.productioncontrol.data.model.AssemblyStageData

@Dao
interface AssemblyStageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAssemblyStageItem(stage : AssemblyStageEntity) : Int

    @Query("SELECT * FROM assembly_stage_table WHERE id = :id")
    suspend fun getAssemblyStageItem(id: Int): AssemblyStageEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAssemblyStageItems(stages: List<AssemblyStageEntity>) : List<Int>

    @Query("SELECT * FROM assembly_stage_table")
    suspend fun getAssemblyStageItems(): List<AssemblyStageEntity>

    @Update
    suspend fun updateAssemblyStageItem(stage: AssemblyStageEntity): Int

    @Query("DELETE FROM assembly_stage_table WHERE id = :id")
    suspend fun deleteAssemblyStageItemById(id : Int) : Int

}