package net.denis.productioncontrol.core.data.interfaces

import androidx.room.*
import net.denis.productioncontrol.core.data.datasources.local.entities.ChecklistItemEntity
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem

@Dao
interface IChecklistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addChecklistItem(checklistItemEntity: ChecklistItemEntity)

    @Query("DELETE FROM checklist_item_table WHERE stage_id = :stageId")
    suspend fun removeAllChecklistItems(stageId: Int)

    @Query("SELECT * FROM checklist_item_table WHERE stage_id = :stageId")
    suspend fun getAllChecklistById(stageId: Int): List<ChecklistItemEntity>
}