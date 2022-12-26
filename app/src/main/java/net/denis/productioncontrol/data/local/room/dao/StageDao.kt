package net.denis.productioncontrol.data.local.room.dao

import androidx.room.*
import net.denis.productioncontrol.data.local.room.entities.StageEntity

@Dao
interface StageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStageItem(stage : StageEntity)

    @Query("SELECT * FROM stage_table WHERE id = :id")
    suspend fun getStageItem(id: Int): StageEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStageItems(stages: List<StageEntity>)

    @Query("SELECT * FROM stage_table")
    suspend fun getStageItems(): List<StageEntity>

    @Update
    suspend fun updateStageItem(stage: StageEntity)

    @Query("DELETE FROM stage_table WHERE id = :id")
    suspend fun deleteStageItemById(id : Int)

}