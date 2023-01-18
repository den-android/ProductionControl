package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities.CompletedChecklistItemEntity

@Dao
interface ICompletedChecklistDao {

    @Insert
    suspend fun addChecklistAnswerItem(completedChecklistItemEntity: CompletedChecklistItemEntity)

    @Delete
    suspend fun removeItem(completedChecklistItemEntity: CompletedChecklistItemEntity)
}