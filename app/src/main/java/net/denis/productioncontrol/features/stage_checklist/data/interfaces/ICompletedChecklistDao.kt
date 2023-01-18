package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities.CompletedChecklistItemEntity

@Dao
interface ICompletedChecklistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addChecklistItem(completedChecklistItemEntity: CompletedChecklistItemEntity)

//    @Query("SELECT * FROM completed_checklist_item_table")
//    suspend fun readCompletedChecklistItem(completedChecklistItemEntity: CompletedChecklistItemEntity)
//
//    @Delete
//    suspend fun removeChecklistItem(completedChecklistItemEntity: CompletedChecklistItemEntity)
}