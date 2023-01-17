package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room

import androidx.room.Dao
import androidx.room.Insert
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities.ChecklistEntity

@Dao
interface IChecklistDao {
    @Insert
    suspend fun addChecklist(checklistEntity: ChecklistEntity)
}